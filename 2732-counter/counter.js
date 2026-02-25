/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    let increment = 0;
    
    return function() {
        let temp = n + increment;
        increment++;
        return temp;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */