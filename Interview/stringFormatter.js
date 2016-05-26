// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(S) {
	// write your code in JavaScript (Node.js 4.0.0)
	if (S !== null) {
		//console.log(S.value);
		var inputStr = S;
		// remove hyphens and spaces
		//console.log(inputStr);
		inputStr = inputStr.replace(/\s/g, '');
		//console.log(inputStr);
		inputStr = inputStr.replace(/-/g, '');

		var counter = 0;

		if ((inputStr !== null) && (inputStr.length > 0)) {
			var strLength = inputStr.length;
			if (strLength > 3) {
				var divisions = strLength / 3;
				if (inputStr.length % 3 === 0)
					for (var i = 0; i < divisions; i++) {
						inputStr += inputStr.substr(i, 3) + '-';
					}
				else if (inputStr.length % 3 > 0) {
					for (var c = 0; c < divisions; c++) {
						inputStr += inputStr.substr(c, 3) + '-';
						counter = c;
					}
					inputStr += '-'
							+ inputStr.substr(counter, (strLength - counter));

					S.value = inputStr;
				}
				return S;
			}
		}

	} else
		return -1;
}