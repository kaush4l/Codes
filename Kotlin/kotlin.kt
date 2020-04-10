fun main(args: Array<String>) { // main function
	println("Hello world!!")

	// val -> read only || var -> mutable variable
	var testString: String = "Kaushal" // Cannot be reassigned later
	// All variables are var and compiler automatically infers type
	// Else we can also mention the variable type

	// template string $ is used to refer var {} for methods
	println("$testString is learning!!! ${testString.length}")

	var nullable: String? = "Empty" // ? for nullable value
	// if nullable, needs to be used to access properties
	println("$nullable is something!!! ${nullable?.length}")
	nullable = null
	// ?: used as substitute value if null
	println("$nullable is something!!! ${nullable?.length ?: -1}")
	dataRanges()
	println(functionalExpression(2))
}

// fun -> function
// name -> method name
// ( vararg : used if multiple values can be sent
// param: paramType = defaultValue)
// : returnType
// fun hello(vararg name: String): String {
fun hello(name: String = "world"): String {
	return "Hello, $name!"
}

// Basic data type
// Boolean, Character, Number, String, Array
// Number again has Byte, Short, Int, Long, Double, Float

var boolean: Boolean = true
var char: Char = 'K'
var num: Number = 123L // Will casted as Long
var byteMin: Byte = Byte.MIN_VALUE;
var byteMax: Byte = Byte.MAX_VALUE;
var shortMin: Short = Short.MIN_VALUE;
var shortMax: Short = Short.MAX_VALUE;
var intMin: Int = Int.MIN_VALUE;
var intMax: Int = Int.MAX_VALUE;
var longMin: Long = Long.MIN_VALUE;
var longMax: Long = Long.MAX_VALUE;
var doubleMin: Double = Double.MIN_VALUE;
var doubleMax: Double = Double.MAX_VALUE;
var floatMin: Float = Float.MIN_VALUE;
var floatMax: Float = Float.MAX_VALUE;

fun dataRanges() {
	println("Boolean value $boolean || false") // 1 bit
	println("Character values like $char") // 8 bit

	println("Short ranges from $shortMin to $shortMax") // 16 bit
	println("Int ranges from $intMin to $intMax") // 32 bit
	println("Long ranges from $longMin to $longMax") // 64 bit
	println("Double ranges from $doubleMin to $doubleMax") // 64 bit
	println("Float ranges from $floatMin to $floatMax") // 32 bit
}

fun functionalExpression(x: Int): Boolean = (x % 2 == 0)

// Constructor in same line as class since redundant and optional keyword
// Constructor cannot have any code but can initialize using init block
class Person constructor(name: String, var age: Int) {
	// for multiple init block they are executed in order appeared in class
	init {
		println("Initializing person with name : $name")
	}
	
}
