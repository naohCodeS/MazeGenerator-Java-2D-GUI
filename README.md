# 迷路自動生成プログラム（2DGUI, 最短経路解表示込）  
  
Javaを用いて迷路自動生成プログラムを作成しました。  
1年ほど前、C言語を用いて作成したものをリファクタリングし、Javaで書き直しました。  
プログラミングを始めたてで書いた前のプログラムよりはましに書けたと思います。  
  
## 前提, 使用環境  
  
Java : jdk-17  
GUI  : JavaFX  
IDE  : Eclipse IDE
  
SceneBuilder（FXML）の利用でリッチなGUIを手軽に作成できますが、今回は使用せずJavaのみでデザインまで行っています。  
実行するにはJavaFXを実行できる環境が必要です。  
  
## 説明 

・迷路（2次元）の自動生成プログラム  
・縦のマス数と横のマス数を指定できる  
・501×501の迷路を3秒程度で生成できる  
・タイトル画面と迷路画面の画面遷移ができる

## 実行写真  

### タイトル画面  

タイトル画面はこんな感じ。  
縦マス数と横マス数を入力して、「迷路生成」ボタンをクリックすると迷路が生成されます。  
縦マス数と横マス数は5以上の奇数である必要があります。異なる値でも大丈夫ですが、不格好になるので近い値にしたほうがいいです。  
<img width="900" alt="タイトル" src="https://user-images.githubusercontent.com/75174022/152810275-b455d2ef-c161-4a82-a961-25e23dd3e285.png">

### 迷路生成した画面

こんな感じになります！  
写真は11×11です。壁やスタート、ゴールの角が丸まっていますが、内部変数の値を変更すれば丸まり具合を調整できます。  
右側に調節するGUIをつけてもいいかも  

<img width="900" alt="迷路" src="https://user-images.githubusercontent.com/75174022/152810341-20165451-4993-4eb1-9c9c-32cd52e0403a.png">

### 最短経路を表示した画面  

「最短経路を表示する」ボタンを押すと最短経路が表示されます。
青で表示したルートが最短経路です。  
ルートの計算方法は、スタートからの幅優先でそれぞれのマスへの最小マス数を求め、ゴールから逆探索で最短経路を出しています。  

<img width="900" alt="最短経路" src="https://user-images.githubusercontent.com/75174022/152810380-f77b3460-cf38-4a5b-97a0-f4f1641c2835.png">

### おまけ

501×501で生成するとこんな感じになります。  
画質が足りない…  
実行時間は3秒くらいです  

<img width="900" alt="501501" src="https://user-images.githubusercontent.com/75174022/152810397-184300b3-b51c-4a96-a5c0-72d0053e1112.png">


## 課題  

たくさんあるけどアルゴリズム部分の課題を書きます。  
解決策があれば教えてほしいです。  

### 迷路が簡単になりがち…?  

迷路生成を壁伸ばし法（参考資料欄を参照のこと）を利用しているので、自分の壁と接続しないために伸ばしている壁をスタックで管理しているが、
管理数が多くなるとStackOverflowErrorが発生する。  
これを回避するためにスタックの最大数を7（経験的にこれくらいが妥当だと思う）に設定しているが、これによりまだ伸ばせる壁を途中で中断する
ことになり、501×501の画像に見るように直線に近い道が最短経路となってしまう。  
  
何か方法あるのかな…  

## 参考資料

迷路生成アルゴリズム（壁伸ばし法）： Algoful 様（<https://algoful.com/Archive/Algorithm/MazeExtend>）
画面遷移　：　のんぽぐ 様（<https://nompor.com/2018/01/16/post-2683/>）
