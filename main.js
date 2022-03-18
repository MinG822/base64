console.log("============== Start Base 64 Encoding & Decoding ! ==================")

const aString = "abc"
console.log("Byte length of abc is " + aString.length)

let aStringInBinary = ""
const format8bit = (bitInString) => {
    return "0"*(8-bitInString.length) + bitInString
}

for (let i = 0; i < aString.length ; i ++) {
    aStringInBinary += format8bit(aString.charCodeAt(i).toString(2))
}

console.log("abc in binary is " + aStringInBinary)
console.log("binary length of abc is " + aStringInBinary.length)

let aStringIndexPer6Bit = ""
for (let i = 0; i < aStringInBinary.length; i=i+6) {
    aStringIndexPer6Bit += parseInt(aStringInBinary.substr(i, 6), 2).toString() + " "
}
console.log("decimal index per 6 bit is " + aStringIndexPer6Bit)

const encodedAString = btoa(aString)
console.log("Base64 Encoded abc is " + encodedAString)
console.log("Base64 Encoded abc length is " + encodedAString.length)

const decodedAString = atob(encodedAString)
console.log("Base64 Decoded abc is " + decodedAString)

console.log("============== End Base 64 Encoding & Decoding ! ==================")



