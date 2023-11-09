const colors = ['red', 'green', 'blue'];
let colorNumber = 25;

switch (colorNumber) {
    case 1:
        console.log(colors[0]);
        break;
    case 2:
        console.log(colors[1]);
        break;
    case 3:
        console.log(colors[2]);
        break;

    case 4:
    case 5:
    case 6:
        console.log('black');
        break;
    default:
        console.log('white');
        break;
}