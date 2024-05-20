//クラス宣言

class Student {

    avg() {
        console.log((80+70)/2);//クラス内の変数をプロパティ、クラス内の関数をメゾットという
    }//avgはメゾット
}//↑クラスから↓インスタンス化

var a001=new Student();
a001.avg();//75と出力される

//引数あり

class Student01{
     avg01(math,english){
         console.log((math+english)/2);
     }

}

var a002=new Student01();
a002.avg01(50,70);



a001.name="sato";
console.log(a001.name)//nameはプロパティ

var a003=new Student();
console.log(a003.name);//undefinedと出力される
//インスタンスごとにプロパティを定義しないといけない
//class2.jsでコンストラクタについて紹介