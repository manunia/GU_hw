package javaLevel2.lesson7_8.chat.server;

public interface AuthService {
    String getNicknameByLoginAndPassword(String login, String password);

    String getNickname(String nick);
}
