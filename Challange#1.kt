import kotlin.system.exitProcess

var balance: Int = 300000

private fun main(){
    runATM()
}

private fun runATM(){
    var pin: String? = null
    println("""
          Welcome to My Bank
        =====================
    """.trimIndent())
    while (pin == null){
        println("Please input your pin: ")
        pin = readLine()
    }
    checkPin(pin)
}

private fun checkPin(pin: String){
    while (pin != "123456"){
        println("""
            Please input correct pin
            ========================
            
        """.trimIndent())
        runATM()
    }
    menu()
}

private fun menu(){
    print("""
        
                    MENU
        =============================
        Choose what do yo want to do?
        1. Withdraw
        2. Check balance
        3. Exit
        Input number(1/2/3): 
    """.trimIndent())
    when(readLine()){
        "1" -> withdraw()
        "2" -> checkBalance()
        "3" -> exitProcess(0)
        else -> {
            print("Error code!")
            menu()
        }
    }
}

private fun withdraw(){
    var amount: Int? = null
    while (amount == null){
        println("\nInput your amount: ")
        try {
            amount = readLine()?.toInt() ?: 0
        } catch (e: Throwable){
            println("Please input number type only!")
            withdraw()
        }
    }
    when{
        amount > balance -> {
            println("""
                Your balance is not enough
                ==========================
            """.trimIndent())
        }
        amount < balance -> {
            balance -= amount
            println("""
                Your balance now $balance
                =========================
            """.trimIndent())
        }
    }
    menu()
}

private fun checkBalance(){
    println("""
        
        Your balance now is $balance
        ============================
        Type (Y) to back...
    """.trimIndent())
    readLine()
    menu()
}