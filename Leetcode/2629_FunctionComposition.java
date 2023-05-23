/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    // accumulator acc will hold the value of previous function execution. for example,
    // const fn = compose([x => x + 1, x => 2 * x]); fn(4)
    // In this case, after first function execution, (acc,f) will be (x => x + 1, 8)
    return x => functions.reduceRight((acc,f)=>f(acc),x)
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */