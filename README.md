『Java SE8 実践プログラミング』輪読会
===================================

[![Build Status](https://travis-ci.org/aosn/java8.svg)](https://travis-ci.org/aosn/java8)

ようこそ！

こちらは [mikan](/mikan) が主催する Java 8 本のオンライン輪読会の Wiki です。

終了報告はこちら → https://aosn.github.io/#!ws1-java8.md

## 本リポジトリの利用方法

### Eclipse で開発する場合

#### 初期設定 (clone)

1. `File` メニューから `Import...` をクリックします。
2. `Git` カテゴリにある `Projects from Git` を選び、` Next > ` ボタンをクリックします。
3. `Clone URI` を選び、` Next > ` ボタンをクリックします。
4. 以下を入力し、``` Next > ``` ボタンをクリックします:
 * `URI:` https://github.com/aosn/java8.git
 * `User:` _your-github-user-name_
 * `Password:` _your-github-user-password_
 * `Store in Secure Store` ☑ でパスワードを保存
5. `master` に ☑ が入っているのを確認し、`Next > ``タンをクリックします。
6. `Directory:` に好みの場所を指定し (またはデフォルトのままで) ` Next > ` ボタンをクリックします。
7. `Import existing projects` が選択されているのを確認し、` Next > ` ボタンをクリックします。
8. `Projects:` に "Exercies" が ☑ されているのを確認し、` Finish ` ボタンをクリックします。

#### 修正の反映 (push)

1. プロジェクトを右クリックし、`Team` メニューから `Commit...` を選択。
2. `Commit message` 欄に変更内容の要約を日本語等で記入し、Files ペインに修正したファイルが追加されていることを確認して Commit and Push ボタンを押す。
3. エラーっぽい表示がなければ完了。

#### 誰かの修正を取り寄せ (pull)

1. プロジェクトを右クリックし、`Team` メニューから `Pull...` を選択すると即座に取得が始まる。
2. 変更があれば適用され、なければ `everything up to date.` などと表示される。GitHub のファイルと、自分の手元で修正したファイルとの間で競合が発生した場合は、競合したファイルのどっちを採用するか選択する手続きをする必要がある (あるいは自分の手元の修正を捨てる)。


### NetBeans で開発する場合

#### 初期設定 (clone)

1. `チーム` メニューから `Git` サブメニューを開き `クローン...` をクリックします。
2. 以下を入力し、``` 次 > ``` ボタンをクリックします:
 * `リポジトリURL:` https://github.com/aosn/java8.git
 * `ユーザー:` _your-github-user-name_
 * `パスワード:` _your-github-user-password_
 * `パスワードを保存` ☑ でパスワードを保存
 * `クローン先:` 好みの場所を指定 (またはデフォルトのまま)
3. `master` に ☑ が入っているのを確認し、`次 > `ボタンをクリックします。
4. そのまま中身をいじらずに ` 終了 ` をクリックします。
5. 正常にクローンできると "クローン完了" ダイアログが表示されるので `プロジェクトを開く` をクリックします。

### IntelliJ で開発する場合

##### 初期設定 (簡易説明)

1. clone します。
2. build, out の各ディレクトリを作ります。
3. `Module Settings` を開きます。
 1. `Project` > `Project SDK:` を 1.8 の JDK に、`Project language level:`を 8 に指定します。
 2. 同 `Project compiler output:` に 先ほどの _build_ ディレクトリを指定します。
 3. `Module` > `Sources` タブで _src_ ディレクトリを `Sources` に、_test_ ディレクトリを `Tests` に、_build_ ディレクトリと _out_ ディレクトリを `Excluded` に指定します。
 4. `Libraries` > `+` で _lib_ ディレクトリにある JUnit の jar ファイルを追加します。 
4. 画面を閉じたらビルドできるはずです。
