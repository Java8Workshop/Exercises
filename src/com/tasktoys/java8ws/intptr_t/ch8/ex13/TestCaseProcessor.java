package com.tasktoys.java8ws.intptr_t.ch8.ex13;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({
		"com.tasktoys.java8ws.intptr_t.ch8.ex13.TestCase",
		"com.tasktoys.java8ws.intptr_t.ch8.ex13.TestCases"})
public class TestCaseProcessor extends AbstractProcessor{
	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {		

		if(annotations.isEmpty()) {
			return true;
		}
		Messager messager = super.processingEnv.getMessager();

		for(TypeElement annotation : annotations) {
			Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(annotation);
			for(Element element : elements) {
				if(element.getKind() != ElementKind.METHOD) {
					continue;
				}
				
				// @TestCaseが点いたテスト対象メソッドを取得
				Optional<Method> targetMethod;
				Object instance;
				try {
					// ※オーバーロード非対応。。。
					targetMethod = Arrays.stream(
							Class.forName(element.getEnclosingElement().toString())
							.getMethods())
							.filter(method -> method.getName().equals(element.getSimpleName().toString()))
							.findFirst();
					
					// クラスメソッドか、インスタンスメソッドか判定
					if(element.getModifiers().contains(Modifier.STATIC)){
						instance = null;
					} else {
						instance = Class.forName(element.getEnclosingElement().toString()).newInstance();
					}
				} catch (ClassNotFoundException |
						 InstantiationException |
						 IllegalAccessException e) {
					throw new RuntimeException(e);
				}
				
				// テスト対象メソッドを実行
				targetMethod.ifPresent((m)->{
					for(TestCase testCase : element.getAnnotationsByType(TestCase.class)){
						int params = Integer.parseInt(testCase.params());
						long expected = Long.parseLong(testCase.expected());

						try {
							long ans = (long)m.invoke(instance, params);
							
							String message = m.getName() + "(" + params + ") => " + expected + " --- " + ans;
							if(expected == ans) {
								System.out.println("OK: " + message);
							} else {
								messager.printMessage(Kind.ERROR, message);
							}
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
					System.out.println();
				});
			}
		
		}		
		return false;
	}
}
