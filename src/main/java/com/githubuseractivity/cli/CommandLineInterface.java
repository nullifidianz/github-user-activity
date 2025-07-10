package com.githubuseractivity.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "github-user-activity", mixinStandardHelpOptions = true, version = "1.0", description = "Exibe a atividade de um usuário do GitHub.")
public class CommandLineInterface implements Runnable {

    @Option(names = { "-u", "--user" }, description = "Nome de usuário do GitHub", required = true)
    private String username;

    @Override
    public void run() {
        // TODO: Chamar GitHubApiClient e exibir eventos do usuário
        System.out.println("Demo: CLI executado com sucesso para o usuário: " + username);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new CommandLineInterface()).execute(args);
        System.exit(exitCode);
    }
}