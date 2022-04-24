package com.amazonaws.gapp;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//TODO: Get GUI up and working
//TODO: Get quiz matching up and working
public class ExchangeStudent implements ActionListener {
	
	
    /**
     * Array of questions designed for students spending time in another country
     */
    String[] questions = {

            "What is your gender?",
            "Do you smoke or live with someone who does?",
            "Do you have any environmental allergies?",
            "Do you have any food allergies?",
            "Are you religious?",
            "Do you have any medical conditions that will need regular treatment? (asthma, diabetes, etc)",
            "Do you prefer to have a separate room?",
            "If you do not smoke, can you stay in a home with smoking?",
            "Will you stay with someone of another gender from you? (You must have separate rooms then.)",
            "Do you have any dietary restrictions?"

    };

    /**
     * Possible answers - most are yes/no. Will include a section to allow them to add in more info
     */
    
    String[][] languageSelect = {
    		{"EN", "DE"}
    };
    
    String[][] options = {
    		
            {"M", "F"},     //need to add other option, need to make button nums variable
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"}
    };
    
    private static final String REGION = "us-east-1";
    
    // Create credentials using a provider chain. For more information, see
    // https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
    AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();
    
    AmazonTranslate translate = AmazonTranslateClient.builder()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds.getCredentials()))
            .withRegion(REGION)
            .build();

    TranslateTextRequest request = new TranslateTextRequest()
            .withText("Hello, world")
            .withSourceLanguageCode("en")
            .withTargetLanguageCode("de");
    TranslateTextResult result  = translate.translateText(request);

    /**
     * additional variables needed for construction of quiz
     */
    String lang;
    char answers;
    char index;
    int total_question = questions.length;

    /**
     * Create GUI
     */
    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();    //Set to "Welcome" + Student name
    JTextArea textArea = new JTextArea();       //Set to question being asked
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();

    JTextField responses = new JTextField();        //show them their responses

    JTextArea possibleMatched = new JTextArea();    //show possible matches

    /**
     * Constructor
     */
    public ExchangeStudent(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.setLayout(null);

        frame.setVisible(true);
    }
    
    public void selectLanguage() {
    	buttonA.setEnabled(true);
    	buttonB.setEnabled(true);
    	
    	textfield.setText("Language");
    	textArea.setText("Select language / Sprache auswaehlen: ");
    	
    	buttonA.setText(languageSelect[0][0]);
    	buttonB.setText(languageSelect[0][1]);
    	answer_labelA.setText(languageSelect[0][0]);
        answer_labelB.setText(languageSelect[0][1]);
    	
    }

    /**
     * Will take us to next question when button is clicked
     * TODO: Include confirmation?
     */
    
    public void nextQuestion(){

    }

    /**
     * Implement method from ActionListener for button clicks
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * After quiz is completed, allow user to check their answers
     */
    public void displayAnswers(){

    }
}

