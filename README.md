# Interpreter task from VMware Talent Boost Class

The interpreter has different commands:

reverse <string>
reverses the letters in the provided string

count-words <string>
counts the number of words in the provided string

reverse-words <string>
reverses the order of the words in the provided string

get <variable>
obtains the value of the given variable name and prints it out in the format:
	[<type>] <value>

set <variable> <type> <value>
creates a new variable of the given type and value

calc <variable1> <variable2> <operation> <variable3>
performs operation between variable2 and variable3 and stores the result in variable1

Supported operations are the follwing:
	string
		+ <string> - concatenates the two strings
		+ <number> - adds the number as string to the end
		* <number> - repeats the string a <number> times
	number
		+ <number> - adds the two numbes
		- <number> - subtracts he two numbers
		* <number> - multiplies the two numbers
	date
		+ <number> - adds a <number> of days
		- <number> - subtracts a <number> of days

load <file_name>
loads variables from file

save <file_name>
saves variables into a file
