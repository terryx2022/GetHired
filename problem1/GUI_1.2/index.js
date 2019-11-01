var idx = 0;

var boxes = [
    function() {
        document.getElementById("box").innerHTML = "1";
    },
    function() {
        document.getElementById("box").innerHTML = "2";
    },
    function() {
        document.getElementById("box").innerHTML = "3";
    }
]

function next() {
    idx = idx == 2 ? 0 : idx + 1;
    boxes[idx]();
}


function foo() {
    document.getElementById("foo").innerHTML = "Hello World";
}

