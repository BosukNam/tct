/**
 * 
 */

function toDash(str) {
	return str.replace(/([A-Z])/g, function ($1) { return "-" + $1.toLowerCase(); });
}

function toCamel(str) {
	return str.replace(/(\-[a-z])/g, function ($1) { return $1.toUpperCase().replace('-', ''); });
}