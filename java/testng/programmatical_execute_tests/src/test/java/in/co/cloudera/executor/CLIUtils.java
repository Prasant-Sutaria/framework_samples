package test.java.in.co.cloudera.executor.executor;

import test.java.in.co.cloudera.executor.CLIParameters;

public class CLIUtils {

    private String[] commandLineArgs;

    protected CLIUtils(String[] commandLineArgs){
        this.commandLineArgs = commandLineArgs;
    }

    protected String getCLIArgument(CLIParameters cliParameter){

        int argIndex = findIndexOfParameterValue(cliParameter);

        if(isIndexWithInRange(argIndex)){
            return commandLineArgs[argIndex];
        }

        return "";
    }

    protected String[] getCLIArguments(CLIParameters cliParameter){

        int argIndex = findIndexOfParameterValue(cliParameter);

        if(isIndexWithInRange(argIndex)){
            return commandLineArgs[argIndex].split(",");
        }

        return new String[0];
    }

    private boolean isIndexWithInRange(int argIndex){
        return argIndex >0 && argIndex<commandLineArgs.length;
    }

    private int findIndexOfParameterValue(CLIParameters cliParameter){
        int argIndex=-1;
        for(int index=0;index<commandLineArgs.length;++index){
            if(commandLineArgs[index].equalsIgnoreCase(cliParameter.getParameter())){
                argIndex = index + 1;
                break;
            }
        }
        return argIndex;
    }

}
