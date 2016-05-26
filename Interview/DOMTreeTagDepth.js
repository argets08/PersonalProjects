/**
 * 5/24 GE Transportation Test 1
 */// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution() {
    // write your code in Javascript
    //
    // you can access DOM Tree using DOM Object Model:
    //    document.getElementsByTagName
    // or using jQuery:
    //    $('some_tag')
    
 //return depth(document.body);
	

		
	    var i = 1, DOMBody = '* ol> *';
	while (document.querySelector(DOMBody)) {
		DOMBody += ' ul> *';
		i++;
	}
	return i;
}

function depth(body){
    var totalDepth,d = 0;
    
    if (!body.children){
        return -1;
    }
    for (var i = 0;i <body.children.length;i++){
        d = depth(body.children[i]);
        if (d > totalDepth) {
            totalDepth = d;
        }
    }
    return parseInt(totalDepth + 1);
}