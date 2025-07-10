package com.githubuseractivity.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Help.Ansi;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

@Command(name = "github-user-activity", mixinStandardHelpOptions = true, version = "1.0", description = "Exibe a atividade de um usuário do GitHub.")
public class CommandLineInterface implements Runnable {

    @Option(names = { "-u", "--user" }, description = "Nome de usuário do GitHub", required = true)
    private String username;

    @Override
    public void run() {
        exibirBanner();
        // TODO: Chamar GitHubApiClient e exibir eventos do usuário
        System.out
                .println(Ansi.ON.string("@|bold,green Demo: CLI executado com sucesso para o usuário:|@ ") + username);
    }

    private void exibirBanner() {
        try {
            String banner = new String(Files.readAllBytes(Paths.get("src/main/resources/banner.txt")));
            System.out.println(Ansi.ON.string("@|bold,blue " + banner + "|@"));
        } catch (IOException e) {
            System.out.println(Ansi.ON.string("@|red Não foi possível carregar o banner.|@"));
        }
    }

    public static void main(String[] args) {
        while (true) {
            int exitCode = new CommandLine(new CommandLineInterface())
                    .setColorScheme(CommandLine.Help.defaultColorScheme(CommandLine.Help.Ansi.ON))
                    .execute(args);
            if (exitCode == 0)
                break;
            System.out.println(Ansi.ON
                    .string("@|bold,red Opção inválida ou argumento faltando. Tente novamente ou use --help.|@"));
            System.out.print(Ansi.ON.string("@|yellow github-activity |> |@"));
            args = new java.util.Scanner(System.in).nextLine().split(" ");

        }
    }
}