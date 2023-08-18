/**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function*(arr) {
    // Through the yield keyword, we can pause function execution and return an intermediate value until the next time the generator is invoked.
    // arr.flat(Infinity) = most flat possible of arr
    for(let i of arr.flat(Infinity)) yield i;
};

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */