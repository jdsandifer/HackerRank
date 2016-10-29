// Standard input setup provided by HackerRank.com:
process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

process.stdin.on('end', function () {
    input_stdin_array = input_stdin.split("\n");
    main();    
});

function readLine() {
    return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line //////////////////// end of provided code

function main() {
    var n_temp = readLine().split(' ');
    var n = parseInt(n_temp[0]);
    var d = parseInt(n_temp[1]);
    a = readLine().split(' ');
    a = a.map(Number);
    
    let b = rotateArray(a, d)
    
    console.log('%s', convertArrayToString(b))

}

// Returns an array rotated the currect amount of rotations
function rotateArray(array, rotations) {
    return array.map((notUsed, index, arr) =>
              rotateIndex(index, arr, rotations))
}
  
// Returns an integer which is the index of the array item 
// to replace the item at the current index for the rotations 
// to be completed
function rotateIndex(index, array, rotations) {
        return (index+rotations < array.length)
                  ? array[index+rotations]
                  : array[index+rotations-array.length]
}

// Returns a string of space separated array values
const convertArrayToString = 
        (array) => array.reduce(
            (result, nextInt) => result + ' ' + nextInt)