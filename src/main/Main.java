package main;

import actions.GiveGifts;
import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import input.Input;
import output.Output;

import java.io.File;
import java.io.IOException;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * This method is used to call the checker which calculates the score
     *
     * @param args the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            ObjectMapper objectMapper = new ObjectMapper();
            Input input = objectMapper.readValue(new File("tests/test" + i
                    + Constants.FILE_EXTENSION), Input.class);
            Output output = Output.getInstance();
            GiveGifts.execute(input, output);
            objectMapper.writerWithDefaultPrettyPrinter().
                    writeValue(new File(Constants.OUTPUT_PATH + i
                            + Constants.FILE_EXTENSION), output);
            output.getAnnualChildren().clear();
        }
        Checker.calculateScore();
    }
}
