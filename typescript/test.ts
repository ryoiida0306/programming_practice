// const getLength = (text : string) => {
//     return text.length
// }

// console.log(getLength("Hello"))
// console.log(getLength("very long string"))
// console.log(getLength(""))

// const double = (array : number[]) : number[] => {
//     return array.map((num) => num *2);
// };

// console.log(double([1,2,3]));

const message = (user : {name : string, age: number}): void => {
    console.log(user.name + "さん・" + user.age + "歳");
};

message({name :"iida.ryo",age :22});