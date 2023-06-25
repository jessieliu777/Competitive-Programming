/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t) {
    // Call fn(...args).
    fn(...args);
    // Set an interval timer. The setInterval function in the code below will call () => fn(...args) every t milliseconds. Note, setInterval does not initially call the function before t milliseconds, which is why we call fn(...args) once before setting the interval.
    let timer = setInterval(() => fn(...args), t);
    // Now, we define a cancelFn function, which clears the interval when called. Return cancelFn.
    // The function cancelFn is not called when our cancellable function is first defined. However, whenever someone calls cancellable, the line return cancelFn, in order to return, will call and execute cancelFn, thereby cancelling the interval. 
    // For example, if we define var myFunc = cancellable((num) => 1 + num, 13, 100), the interval will repeatedly call (num) => 1 + num until myFunc() is called. When myFunc() is called, the return line in myFunc is read, which will consequentially make cancelFn execute and return, thereby clearing the interval.
    let cancelFn = () => clearInterval(timer);
    return cancelFn;
};

/**
 *  const result = []
 *
 *  const fn = (x) => x * 2
 *  const args = [4], t = 20, cancelT = 110
 *
 *  const start = performance.now()
 *
 *  const log = (...argsArr) => {
 *		const val = fn(...argsArr)
 *      result.push({"time": Math.floor(performance.now() - start), "returned": fn(...argsArr)})
 *  }
 *       
 *  const cancel = cancellable(log, args, t);
 *           
 *  setTimeout(() => {
 *     cancel()
 *     console.log(result) // [
 *                         //      {"time":0,"returned":8},
 *                         //      {"time":20,"returned":8},
 *                         //      {"time":40,"returned":8},           
 *                         //      {"time":60,"returned":8},
 *                         //      {"time":80,"returned":8},
 *                         //      {"time":100,"returned":8}
 *                         //  ]
 *  }, cancelT)
 */