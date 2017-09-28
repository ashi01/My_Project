# My_Project 
PROBLEM STATEMENT:

Implement a small message processing application that satisfies the below requirements for
processing sales notification messages. You should assume that an external company will be sending
you the input messages, but for the purposes of this exercise you are free to define the interfaces.
Processing requirements
    •    All sales must be recorded
    •    All messages must be processed
    •    After every 10th message received your application should log a report detailing the number of sales of each 
         product and their total value.
    •    After 50 messages your application should log that it is pausing, stop accepting new messages and log a report 
         of the adjustments that have been made to each sale type while the application was running.

Sales and Messages
    •    A sale has a product type field and a value – you should choose sensible types for these.
    •    Any number of different product types can be expected. There is no fixed set.
    •    A message notifying you of a sale could be one of the following types
    •    Message Type 1 – contains the details of 1 sale E.g apple at 10p
    •    Message Type 2 – contains the details of a sale and the number of occurrences of that sale. E.g 20 sales of 
         apples at 10p each.
    •    Message Type 3 – contains the details of a sale and an adjustment operation to be applied to all stored sales of
         this product type. Operations can be add, subtract, or multiply e.g Add 20p apples would instruct your application 
         to add 20p to each sale of apples you have recorded.
         
   SOLUTION (Working of Code):
   
    The main class InitApp runs when the code is executed, it is interlinked to other classes in sub packages of   
      Main package. 
    The input is taken from user through Console first, this input is than compared to with valid message formats 
    to check if the input entered by the user is valid message type. If the input entered is one of the three message 
    types given in problem statement than, it is written into an input file which than passes this data to the objects
    that read data from input file (DataInputFile.txt).
    
    This input is than checked for the type, to see if it is of MessageType1 or MessageType2/MessageType3. 
    
    Assumption is made that the product is fruit and is of one of them that is specified in enum Fruit.
    
    Based on Type of incoming message, the operations are performed on each type of message and the processed 
    messages are written out in OutputData.txt.
    
    The class ApplicationTestClass tests the input for all 3 message types. 
    
    MainFrame :-     This folder contains 4 classes that are run when the application is initialized. InitateApp     
                   contains the main program that executes first when the application is loaded. 
                 
    MessageOperations :-  This folder consists of all classes that perform various operations on incoming messages 
                          of three different types.Message is an interface that is implemenented by it's sub-classes.
                         
    Reports :-    This folder contains an interface Reports that is implemented by other classes in this folder to generate 
                  the log report and to print them in output file.
                
    TestClasses :-   This folder consists of input and output files and the test classes which contains test functions to
                      test all 3 message types.
    
