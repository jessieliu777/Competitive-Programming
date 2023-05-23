/**
 * @param {any} object
 * @param {any} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    //     Intuition
    // In Javascript, inheritance is achieved with the prototype chain.We can get the prototype of an object with the
    // Object.getPrototypeOf(obj)
    // using this compare class prototype with objects prortotype.

    // Approach
    // We will Traverse the entire prototype chain until we find a match or else return False.

    // Complexity
    // Time complexity: O(n)
    // The time complexity of the function depends on the depth of the prototype chain of the object being checked.
    // In the worst case, when the prototype chain is very deep, the function may take O(n) time, where n is the depth of the prototype chain.
    // Space complexity:O(1)
    // The space complexity of the function is constant, as it does not use any additional data structures that grow with the size of the input.
    while(obj!=null)
    {
        if(obj.constructor === classFunction) return true;
        obj = Object.getPrototypeOf(obj);
    }
    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */