module emprestimos {
	requires java.sql;
	requires javafx.controls;
	requires javafx.graphics;
	opens app to javafx.controls, javafx.graphics;
}