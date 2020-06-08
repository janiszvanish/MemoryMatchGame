package pl.pjatk.projekt.nie_uzywane;

public enum CardEnum {
    IMAGE0("/images/arcticfox.png"),
    IMAGE1("/images/bear.png"),
    IMAGE2("/images/camel.png"),
    IMAGE3("/images/cat.png"),
    IMAGE4("/images/crocodile.png"),
    IMAGE5("/images/elephant.png"),
    IMAGE6("/images/frog.png"),
    IMAGE7("/images/giraffe.png"),
    IMAGE8("/images/lamp.png"),
    IMAGE9("/images/monkey.png"),
    IMAGE10("/images/mouse.png"),
    IMAGE11("/images/panda.png"),
    IMAGE12("/images/polarbear.png"),
    IMAGE13("/images/reindeer.png"),
    IMAGE14("/images/seal.png"),
    IMAGE15("/images/sheep.png"),
    IMAGE16("/images/turtle.png"),
    IMAGE17("/images/warlus.png");
    ;

    String path;

    CardEnum(String path) {
        this.path = path;
    }
}
