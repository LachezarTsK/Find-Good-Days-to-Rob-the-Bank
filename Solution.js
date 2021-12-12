
/**
 * @param {number[]} security
 * @param {number} time
 * @return {number[]}
 */
var goodDaysToRobBank = function (security, time) {

    const size = security.length;
    if (size < 2 * time + 1) {
        return [];
    }

    const result = [];
    if (time === 0) {
        for (let i = 0; i < size; i++) {
            result.push(i);
        }
        return result;
    }

    const goodDays = [];
    let counterGoodDaysBefore = 0;
    for (let i = 1; i < size; i++) {
        if (security[i - 1] >= security[i]) {
            goodDays[i] = ++counterGoodDaysBefore;
        } else {
            counterGoodDaysBefore = 0;
        }
    }

    let counterGoodDaysAfter = 0;
    for (let i = size - 2; i >= 0; i--) {
        if (security[i + 1] >= security[i]) {
            if (Math.min(goodDays[i], ++counterGoodDaysAfter) >= time) {
                result.push(i);
            }
        } else {
            counterGoodDaysAfter = 0;
        }
    }

    return result;
};
