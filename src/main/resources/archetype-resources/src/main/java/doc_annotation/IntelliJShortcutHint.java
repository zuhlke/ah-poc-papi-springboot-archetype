package ${package}.doc_annotation;

import java.lang.annotation.Repeatable;

/**
 * There is an opportunity here to use a keyboard shortcut to improve the way you develop. Have a go!
 * <br/>
 * These shortcuts are made for the standard "Mac OS X" keymap.
 * <br/>
 * If you can't quite remember a shortcut, ctrl-alt-a(find action) opens a search bar where you can
 * search for the name of a shortcut to get the key combination.
 */
@Repeatable(IntelliJShortcutHints.class)
public @interface IntelliJShortcutHint {
    String value();
}