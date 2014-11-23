練習問題回答共有リポジトリ
=========

こちらは『Java SE8 実践プログラミング』輪読会の練習問題回答共有リポジトリです。輪読会については[こちら](https://github.com/Java8Workshop/About)をご覧ください。

## Eclipse で開発する場合

### 初期設定 (clone)

1. `File` メニューから `Import...` をクリックします。
2. `Git` カテゴリにある `Projects from Git` を選び、` Next > ` ボタンをクリックします。
3. `Clone URI` を選び、` Next > ` ボタンをクリックします。
4. 以下を入力し、``` Next > ``` ボタンをクリックします:
 * `URI:` https://github.com/Java8Workshop/Exercises.git
 * `User:` _your-github-user-name_
 * `Password:` _your-github-user-password_
 * `Store in Secure Store` ☑ でパスワードを保存
5. `master` に ☑ が入っているのを確認し、`Next > ``タンをクリックします。
6. `Directory:` に好みの場所を指定し (またはデフォルトのままで) ` Next > ` ボタンをクリックします。
7. `Import existing projects` が選択されているのを確認し、` Next > ` ボタンをクリックします。
8. `Projects:` に "Exercies" が ☑ されているのを確認し、` Finish ` ボタンをクリックします。

### 修正の反映 (push)

1. プロジェクトを右クリックし、`Team` メニューから `Commit...` を選択。
2. `Commit message` 欄に変更内容の要約を日本語等で記入し、Files ペインに修正したファイルが追加されていることを確認して Commit and Push ボタンを押す。
3. エラーっぽい表示がなければ完了。

### 誰かの修正を取り寄せ (pull)

1. プロジェクトを右クリックし、`Team` メニューから `Pull...` を選択すると即座に取得が始まる。
2. 変更があれば適用され、なければ `everything up to date.` などと表示される。GitHub のファイルと、自分の手元で修正したファイルとの間で競合が発生した場合は、競合したファイルのどっちを採用するか選択する手続きをする必要がある (あるいは自分の手元の修正を捨てる)。
3. 
## NetBeans で開発する場合

1. `チーム` メニューから `Git` サブメニューを開き `クローン...` をクリックします。
2. 以下を入力し、``` 次 > ``` ボタンをクリックします:
 * `リポジトリURL:` https://github.com/Java8Workshop/Exercises.git
 * `ユーザー:` _your-github-user-name_
 * `パスワード:` _your-github-user-password_
 * `パスワードを保存` ☑ でパスワードを保存
 * `クローン先:` 好みの場所を指定 (またはデフォルトのまま)
3. `master` に ☑ が入っているのを確認し、`次 > `ボタンをクリックします。
4. そのまま中身をいじらずに ` 終了 ` をクリックします。
5. 正常にクローンできると "クローン完了" ダイアログが表示されるので `プロジェクトを開く` をクリックします。


