function printNumbers(to) {
    for (let i = 1; i <= to; i++) {
        console.log(i);
    }
}

function add(firstNumber, SecondNumber) {
    return firstNumber + SecondNumber;
}

printNumbers(add(2, 7));