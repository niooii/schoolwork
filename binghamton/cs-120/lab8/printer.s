		.data
hello:	.asciiz "Hewitt Wang\n"

		.text

main:	li $v0, 4
		la $a0, hello
		syscall

		li $a1, 18
		li $a2, 27

		add $a0, $a1, $a2
		addi $a0, $a0, -11
		li $v0 1
		syscall

		li $v0, 10
		syscall
