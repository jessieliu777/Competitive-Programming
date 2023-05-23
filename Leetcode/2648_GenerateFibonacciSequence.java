/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    // yield pauses fx execution and returns value, before continuing subsequent steps
    let a = 0;
    let b = 1;

    while (true){
        yield a;
        [a,b] = [b,a+b];
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */