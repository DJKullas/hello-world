
.data 
input: .asciiz "Input a positive number to find the factorial: "
output: .asciiz "The factorial of your number is: "

.text
main:
                      # ans = x * fact(x - 1); x = $t4
la $a0, input	      # loads address of input string into argument register
li $v0, 4             # system call to print a string
syscall               # prints the string

li $v0, 5             # system to call to read an int
syscall               # reads the int
move $t4, $v0         # moves value of previous syscall into register

addi $t5, $t4, -1     # t5 = t4 - 1; # t5: x-1
move $a0, $t5         # moves value in temp register into argument register
jal fact              # jumps to fact and sets return address
  
mul $t0, $v0, $t4     # $t0 = $v0 * $t4
  
la $a0, output        # loads address of output string into argument register
li $v0, 4             # system call to print a string
syscall               # prints the string

la $a0, ($t0)         # loads address of answer into argument register
li $v0, 1             # system call to print a string
syscall               # prints the string

li  $v0,10            # system call to exit
syscall               # exits

fact:

addi $sp, $sp, -40    # allocate call frame with 10 words
move $t0, $a0         # move argument given to fact into register
sw $ra, 16($sp)       # stores the return address for later use
sw $t0, 12($sp)       # stores the current x value for later use
blt $t0, 2, base      # checks if base case has been met, uses less than to handle 1 as input
  
addi $t1, $t0, -1     # t1 =  x - 1
move $a0, $t1         # move current value into argument register for fact call

jal fact              # jumps to fact 
lw $ra, 16($sp)       # loads previous return address
lw $t0, 12($sp)       # loads previous value at this step in the factorial
  
move $t2, $v0         # move current value of fact call into register
mul $t3, $t0, $t2     # t3 = $t0 * $t2; t3 = x * fact(x - 1)  

move $v0, $t3         # move answer into value register
addi $sp, $sp, 40     # deallocate call frame so outer function will see its call frame
jr $ra                # returns to fact or main depending on caller
  
base: 

li $t0, 1             # load 1 into temp register
move $v0, $t0         # move 1 into value register
jr      $ra           # returns to caller






