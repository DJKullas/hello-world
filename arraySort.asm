.data
mydata: .space 64
names:
.align 5  # in our example, names start on a 32-byte boundary
.asciiz "Joe"
.align 5
.asciiz "Jenny"
.align 5  
.asciiz "Jill"
.align 5
.asciiz "John"
.align 5  
.asciiz "Jeff"
.align 5
.asciiz "Joyce"
.align 5  
.asciiz "Jerry"
.align 5
.asciiz "Janice"
.align 5  
.asciiz "Jake"
.align 5
.asciiz "Jonna"
.align 5  
.asciiz "Jack"
.align 5
.asciiz "Jocelyn"
.align 5  
.asciiz "Jessie"
.align 5
.asciiz "Jess"
.align 5  
.asciiz "Janet"
.align 5
.asciiz "Jane"
.align 5

firstString: .asciiz "Initial array is:\n"
finishedString: .asciiz "Insertion sort is finished!\n"
firstBrace: .asciiz "["
lastBrace: .asciiz "]\n"
spaces: ", "

.text
main:
li $t2, 0		# $t2 = 0
la $t0, firstString	

move $a0, $t0
li $v0, 4
syscall			# prints opening string

la $t5, names		# loads names
la $t6, mydata		# loads mydata
move $a0, $t2
jal setup		# initializes data and prints array
	
la $a0, mydata		
jal sort		# sorts array
li $v0, 10
syscall			# exits
		
setup: 
move $t3, $a0
beq $t3, 16, printHelp
addi $t3, $t3, 1
	 
 
sw $t5, 0($t6) 		# stores address in mydata
addi $t5, $t5, 32	# moves pointer
addi $t6, $t6, 4  	# moves to next element of mydata
move $a0, $t3
j setup
  
printHelp:
la $a0, firstBrace
li $v0, 4
syscall			# prints brace

la $a0, mydata
li $a1, 1
j printArray		# prints names in array
  
printArray:
addi $sp, $sp -4	# allocates memory
move $t7, $a0
move $t8, $a1
  
lw $a0, 0($t7) 
li $v0, 4
syscall			# prints item in array
  
beq $t8, 16, finishPrint 
addi $t8, $t8, 1	# adds 1 to counter
	
la $a0, spaces
li $v0, 4
syscall			# prints spaces and commas
	
addi $t7, $t7, 4	# adds 4 to get to next memory item
move $a0, $t7
move $a1, $t8
j printArray		# prints array
	
finishPrint: 
la $a0, lastBrace	
li $v0, 4
syscall			# prints final brace
jr $ra

sort:
addi $sp, $sp, -24	# allocates memory
li $t1, 0		# $t1 = 0
	
wordLoop:
addi $t1, $t1, 1	# adds 1 to $t1
la $t0, mydata
	
beq $t1, 16, printFinished
mul $t2, $t1, 4		# $t2 = $t1 * 4

add $t3, $t0, $t2	# $t3 = $t2 + $t0
la $a0, ($t3)		
la $a1, ($t0)
li $a2, 0
li $v0, 0
	
compareLoop:
move $t7, $a1
move $t5, $a0
move $s1, $a2
li $v1, 0
lw $k0, ($t7)		# loads first word in array
lw $k1, ($t5)		# loads current word in loop
add $k0, $k0, $s1	# $k0 = $k0 + $s1
add $k1, $k1, $s1	# $k1 = $k1 + $s1
addi $s1, $s1, 1	# adds 1 to $s1
lb $t9, ($k1)		# loads first character
lb $t6, ($k0)		# loads first character
addi $s4, $t1, -1	# $s4 = $t1 - 1
beq $v0, $t1, placeWord
blt $t9, $t6, placeWord
bgt $t9, $t6, moveDown
move $a0, $t5
move $a1, $t7
move $a2, $s1
j compareLoop		# compares words
	
placeWord:
beq $v0, $t1, wordLoop
addi $s4, $s4, 1	# $s4 = $s4 + 1
addi $s2, $t1, -1	# $s2 = $t1 - 1
mul $s2, $t1, 4		# $s2 = $t1 * 4
add $s3, $s2, $t0	# $s3 = $s2 + $t0
lw $t3, ($s3)
mul $k0, $v0, 4		# $k0 = $v0 * 4
add $k1, $t0, $k0	# $k1 = $t0 + $k0
lw $t2, ($k1)
sw $t3, ($k1)
sw $t2, ($s3)
addi $v0, $v0, 1	# $v0 = $v0 + 1
j placeWord		# places words in correct spot in array

moveDown:
addi $v0, $v0, 1	# adds 1 to $v0
addi $a1, $t7, 4	# $a1 = $t7 + 4
move $a0, $t5
li $a2, 0
j compareLoop		# compares words

printFinished:
la $a0, finishedString
li $v0, 4
syscall			# prints finished string
j printHelp		# helps print array
	
	
	
	

	 
	
	
	
	

