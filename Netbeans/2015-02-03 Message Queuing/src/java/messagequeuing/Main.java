//**********************************************************************
//
// MessageApp
//
//**********************************************************************
//***************************************//
// package //
//***************************************//
package messagequeuing;

//***************************************//
// imports //
//***************************************//
import javax.jms.*;

/**
 * *********************************************************************
 * This class provides a test application for the MessageSender and
 * MessageReceiver classes.
 * 
 * @author T.A. Nguyen
 * @version 1.0, Jan 1, 2005
**********************************************************************
 */
public class Main
{

    /**
     * ******************************************************************
     * Application main entry point.
     *******************************************************************
     */
    public static void main(String[] args)
    {
        try
        {
            //--------------------------------
            // Establish sender and receiver
            //--------------------------------
            MessageSender sender = new MessageSender();
            sender.connect();

            MessageReceiver receiver = new MessageReceiver();
            receiver.connect();

            //--------------------------------
            // Create a text message
            //--------------------------------
            TextMessage message = sender.createTextMessage();
            message.setText("This is a test text message");

            //--------------------------------
            // Send the message
            //--------------------------------
            System.out.println("Sending message: " + message.getText());
            sender.send(message);

            //--------------------------------
            // Sleep for a few seconds
            //--------------------------------
            try
            {
                Thread.sleep(3 * 1000);
            }
            catch (InterruptedException ex)
            {
            }

            //--------------------------------
            // Retrieve the message
            //--------------------------------
            TextMessage receivedMessage = (TextMessage) receiver.receive();
            System.out.println("Message received: " + receivedMessage.getText());

            //--------------------------------
            // Terminate connections
            //--------------------------------
            sender.disconnect();
            receiver.disconnect();
        }
        catch (JMSException jmsEx)
        {
            System.out.println("JMS Exception: " + jmsEx);
        }
        catch (MessageException msgEx)
        {
            System.out.println("Message Exception: " + msgEx);
        }
    }
}
