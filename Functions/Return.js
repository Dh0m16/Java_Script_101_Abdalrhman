function printNumber(to) {
    for (let i = 1; i <= to; i++) {
        console.log(i);
    }
}

function add(firstNumber, SecondNumber) {
    let result = firstNumber + SecondNumber;
    return result;
}

let value = add(2, 7);
console.log(value);