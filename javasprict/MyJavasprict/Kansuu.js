//関数の定義

//function 関数名（引数名,引数名,...）｛
//実行したい処理
//}

function say_hello(){
    console.log("Hello World");
}
say_hello();//Hello Worldと出力される

//関数を変数に代入

//var 変数名=funcution　関数名（）｛
//実行したい処理
//}; ←セミコロン注意?なくても良き？

var hello=function say_hello(){//
    console.log("Good Morning");
}

hello();

//引数のある関数

function say_hello01(greeting){//仮引数
    console.log(greeting);
}

say_hello01("Good Morning");//実引数
say_hello01("ohayou");

//計算
function cal(x){
    console.log(x*3);
}

cal(6)//18と出力される

function call01(y,z){
    console.log(y/z);
}

call01(6,3);//2と出力される

//returnあり

function cal02(a,b){
    return a/b;
}

var result=cal02(10,5);
console.log(result);

//returnありだと、返したのちにさらにそれを使って計算ができる。
//比べて無しだと、それができない
//（console.logで表示しているだけなので、そこから変形ができない）