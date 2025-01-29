# HEWITT WANG LAB 9

    .data
x:  .word 3
    .word 37
    .word 2
    .word 7
    .word 41
    .word 0
prompt: .asciiz "sum is "
    .text
main:   la $s0, x
		li $s1, 0
		li $s2, 0
		li $s3, 5
		li $s4, 40
			
while: 	
	lw $s2, 0($s0)
	beq $s2, $0, finish

	ble $s2, $s3, skip
	bge $s2, $s4, skip

	add $s1, $s1, $s2
	

skip:	
	addi $s0, $s0, 4

	j while

finish:
    li $v0, 4
    la $a0, prompt
    syscall
    li $v0, 1
    move $a0, $s1
    syscall
    li $v0, 10
    syscall    
