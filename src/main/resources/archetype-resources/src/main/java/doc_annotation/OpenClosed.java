package ${package}.doc_annotation;

/**
 * Classes annotated with <strong>@OpenClosed</strong> have been authored with the intention that they conform
 * to the open-closed principle.
 * <br/>
 * - It is <strong>OPEN for EXTENSION</strong>
 * <br/>
 * - It is <strong>CLOSED for MODIFICATION</strong>
 * <br/>
 * That means when you want to add new functionality, you should try to EXTEND it with
 * new methods, fields etc.
 * <br/>
 * You should NOT MODIFY the existing methods, fields etc.
 */
public @interface OpenClosed {
}
