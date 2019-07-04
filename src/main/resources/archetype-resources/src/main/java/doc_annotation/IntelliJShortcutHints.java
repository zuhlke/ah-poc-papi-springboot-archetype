package ${package}.doc_annotation;

/*
    This class exists in order to enable the use of the IntelliJShortcutHint annotation
    multiple times on a single method or class.
*/
public @interface IntelliJShortcutHints {
    IntelliJShortcutHint[] value();
}
