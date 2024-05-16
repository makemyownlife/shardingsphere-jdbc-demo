// Generated from /Users/zhangyong/workspace/java/shardingsphere-jdbc-demo/antlr-learning/antlr-shardingsphere/src/mysql/MySQLStatement.g4 by ANTLR 4.13.1

 package cn.javayong.antlr.shardingsphere.autogen;
 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MySQLStatementParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MySQLStatementVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#execute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecute(MySQLStatementParser.ExecuteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterStatement(MySQLStatementParser.AlterStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTable(MySQLStatementParser.CreateTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#startTransaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartTransaction(MySQLStatementParser.StartTransactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#partitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionClause(MySQLStatementParser.PartitionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#partitionTypeDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionTypeDef(MySQLStatementParser.PartitionTypeDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#subPartitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubPartitions(MySQLStatementParser.SubPartitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#partitionKeyAlgorithm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionKeyAlgorithm(MySQLStatementParser.PartitionKeyAlgorithmContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#duplicateAsQueryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuplicateAsQueryExpression(MySQLStatementParser.DuplicateAsQueryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTable(MySQLStatementParser.AlterTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#standaloneAlterTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandaloneAlterTableAction(MySQLStatementParser.StandaloneAlterTableActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterTableActions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableActions(MySQLStatementParser.AlterTableActionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterTablePartitionOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablePartitionOptions(MySQLStatementParser.AlterTablePartitionOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterCommandList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterCommandList(MySQLStatementParser.AlterCommandListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterList(MySQLStatementParser.AlterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createTableOptionsSpaceSeparated}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableOptionsSpaceSeparated(MySQLStatementParser.CreateTableOptionsSpaceSeparatedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addColumn}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddColumn(MySQLStatementParser.AddColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addTableConstraint}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddTableConstraint(MySQLStatementParser.AddTableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code changeColumn}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeColumn(MySQLStatementParser.ChangeColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modifyColumn}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyColumn(MySQLStatementParser.ModifyColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableDrop}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableDrop(MySQLStatementParser.AlterTableDropContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disableKeys}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisableKeys(MySQLStatementParser.DisableKeysContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enableKeys}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnableKeys(MySQLStatementParser.EnableKeysContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterColumn}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterColumn(MySQLStatementParser.AlterColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterIndex}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterIndex(MySQLStatementParser.AlterIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterCheck}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterCheck(MySQLStatementParser.AlterCheckContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterConstraint}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterConstraint(MySQLStatementParser.AlterConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code renameColumn}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameColumn(MySQLStatementParser.RenameColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterRenameTable}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterRenameTable(MySQLStatementParser.AlterRenameTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code renameIndex}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameIndex(MySQLStatementParser.RenameIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterConvert}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterConvert(MySQLStatementParser.AlterConvertContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableForce}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableForce(MySQLStatementParser.AlterTableForceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterTableOrder}
	 * labeled alternative in {@link MySQLStatementParser#alterListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableOrder(MySQLStatementParser.AlterTableOrderContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterOrderList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterOrderList(MySQLStatementParser.AlterOrderListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableConstraintDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableConstraintDef(MySQLStatementParser.TableConstraintDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterCommandsModifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterCommandsModifierList(MySQLStatementParser.AlterCommandsModifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterCommandsModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterCommandsModifier(MySQLStatementParser.AlterCommandsModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#withValidation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithValidation(MySQLStatementParser.WithValidationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#standaloneAlterCommands}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStandaloneAlterCommands(MySQLStatementParser.StandaloneAlterCommandsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterPartition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterPartition(MySQLStatementParser.AlterPartitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#constraintClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintClause(MySQLStatementParser.ConstraintClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableElementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableElementList(MySQLStatementParser.TableElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableElement(MySQLStatementParser.TableElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#restrict}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestrict(MySQLStatementParser.RestrictContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#fulltextIndexOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFulltextIndexOption(MySQLStatementParser.FulltextIndexOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTable(MySQLStatementParser.DropTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropIndex(MySQLStatementParser.DropIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#algorithmOptionAndLockOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlgorithmOptionAndLockOption(MySQLStatementParser.AlgorithmOptionAndLockOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterAlgorithmOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterAlgorithmOption(MySQLStatementParser.AlterAlgorithmOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterLockOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterLockOption(MySQLStatementParser.AlterLockOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#truncateTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruncateTable(MySQLStatementParser.TruncateTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndex(MySQLStatementParser.CreateIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabase(MySQLStatementParser.CreateDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDatabase(MySQLStatementParser.AlterDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createDatabaseSpecification_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDatabaseSpecification_(MySQLStatementParser.CreateDatabaseSpecification_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterDatabaseSpecification_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDatabaseSpecification_(MySQLStatementParser.AlterDatabaseSpecification_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropDatabase(MySQLStatementParser.DropDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterInstance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterInstance(MySQLStatementParser.AlterInstanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#instanceAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceAction(MySQLStatementParser.InstanceActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#channel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannel(MySQLStatementParser.ChannelContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateEvent(MySQLStatementParser.CreateEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterEvent(MySQLStatementParser.AlterEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropEvent(MySQLStatementParser.DropEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFunction(MySQLStatementParser.CreateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterFunction(MySQLStatementParser.AlterFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropFunction(MySQLStatementParser.DropFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createProcedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateProcedure(MySQLStatementParser.CreateProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterProcedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterProcedure(MySQLStatementParser.AlterProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropProcedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropProcedure(MySQLStatementParser.DropProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createServer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateServer(MySQLStatementParser.CreateServerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterServer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterServer(MySQLStatementParser.AlterServerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropServer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropServer(MySQLStatementParser.DropServerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateView(MySQLStatementParser.CreateViewContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterView(MySQLStatementParser.AlterViewContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropView(MySQLStatementParser.DropViewContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createTablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTablespace(MySQLStatementParser.CreateTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createTablespaceInnodb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTablespaceInnodb(MySQLStatementParser.CreateTablespaceInnodbContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createTablespaceNdb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTablespaceNdb(MySQLStatementParser.CreateTablespaceNdbContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterTablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablespace(MySQLStatementParser.AlterTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterTablespaceNdb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablespaceNdb(MySQLStatementParser.AlterTablespaceNdbContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterTablespaceInnodb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTablespaceInnodb(MySQLStatementParser.AlterTablespaceInnodbContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropTablespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTablespace(MySQLStatementParser.DropTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createLogfileGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateLogfileGroup(MySQLStatementParser.CreateLogfileGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterLogfileGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterLogfileGroup(MySQLStatementParser.AlterLogfileGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropLogfileGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropLogfileGroup(MySQLStatementParser.DropLogfileGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createTrigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTrigger(MySQLStatementParser.CreateTriggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropTrigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTrigger(MySQLStatementParser.DropTriggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#renameTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameTable(MySQLStatementParser.RenameTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createDefinitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDefinitionClause(MySQLStatementParser.CreateDefinitionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(MySQLStatementParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#fieldDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDefinition(MySQLStatementParser.FieldDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#columnAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnAttribute(MySQLStatementParser.ColumnAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#checkConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckConstraint(MySQLStatementParser.CheckConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#constraintEnforcement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintEnforcement(MySQLStatementParser.ConstraintEnforcementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#generatedOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratedOption(MySQLStatementParser.GeneratedOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#referenceDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceDefinition(MySQLStatementParser.ReferenceDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#onUpdateDelete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnUpdateDelete(MySQLStatementParser.OnUpdateDeleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#referenceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceOption(MySQLStatementParser.ReferenceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#indexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexType(MySQLStatementParser.IndexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#indexTypeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexTypeClause(MySQLStatementParser.IndexTypeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#keyParts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyParts(MySQLStatementParser.KeyPartsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#keyPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyPart(MySQLStatementParser.KeyPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#keyPartWithExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyPartWithExpression(MySQLStatementParser.KeyPartWithExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#keyListWithExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyListWithExpression(MySQLStatementParser.KeyListWithExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#indexOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOption(MySQLStatementParser.IndexOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#commonIndexOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonIndexOption(MySQLStatementParser.CommonIndexOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#visibility}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibility(MySQLStatementParser.VisibilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createLikeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateLikeClause(MySQLStatementParser.CreateLikeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createIndexSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndexSpecification(MySQLStatementParser.CreateIndexSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createTableOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableOptions(MySQLStatementParser.CreateTableOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createTableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableOption(MySQLStatementParser.CreateTableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createSRSStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSRSStatement(MySQLStatementParser.CreateSRSStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropSRSStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSRSStatement(MySQLStatementParser.DropSRSStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#srsAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSrsAttribute(MySQLStatementParser.SrsAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#place}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlace(MySQLStatementParser.PlaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#partitionDefinitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionDefinitions(MySQLStatementParser.PartitionDefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#partitionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionDefinition(MySQLStatementParser.PartitionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#partitionLessThanValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionLessThanValue(MySQLStatementParser.PartitionLessThanValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#partitionValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionValueList(MySQLStatementParser.PartitionValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#partitionDefinitionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionDefinitionOption(MySQLStatementParser.PartitionDefinitionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#subpartitionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubpartitionDefinition(MySQLStatementParser.SubpartitionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#ownerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOwnerStatement(MySQLStatementParser.OwnerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#scheduleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScheduleExpression(MySQLStatementParser.ScheduleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#timestampValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampValue(MySQLStatementParser.TimestampValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#routineBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineBody(MySQLStatementParser.RoutineBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#serverOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerOption(MySQLStatementParser.ServerOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#routineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineOption(MySQLStatementParser.RoutineOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#procedureParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureParameter(MySQLStatementParser.ProcedureParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#fileSizeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileSizeLiteral(MySQLStatementParser.FileSizeLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatement(MySQLStatementParser.SimpleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(MySQLStatementParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#validStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidStatement(MySQLStatementParser.ValidStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#beginStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginStatement(MySQLStatementParser.BeginStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#declareStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareStatement(MySQLStatementParser.DeclareStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#flowControlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlowControlStatement(MySQLStatementParser.FlowControlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#caseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatement(MySQLStatementParser.CaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MySQLStatementParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#iterateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterateStatement(MySQLStatementParser.IterateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#leaveStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeaveStatement(MySQLStatementParser.LeaveStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(MySQLStatementParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStatement(MySQLStatementParser.RepeatStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MySQLStatementParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MySQLStatementParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#cursorStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorStatement(MySQLStatementParser.CursorStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#cursorCloseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorCloseStatement(MySQLStatementParser.CursorCloseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#cursorDeclareStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorDeclareStatement(MySQLStatementParser.CursorDeclareStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#cursorFetchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorFetchStatement(MySQLStatementParser.CursorFetchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#cursorOpenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorOpenStatement(MySQLStatementParser.CursorOpenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#conditionHandlingStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionHandlingStatement(MySQLStatementParser.ConditionHandlingStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#declareConditionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareConditionStatement(MySQLStatementParser.DeclareConditionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#declareHandlerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareHandlerStatement(MySQLStatementParser.DeclareHandlerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#getDiagnosticsStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetDiagnosticsStatement(MySQLStatementParser.GetDiagnosticsStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#statementInformationItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementInformationItem(MySQLStatementParser.StatementInformationItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#conditionInformationItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionInformationItem(MySQLStatementParser.ConditionInformationItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#conditionNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionNumber(MySQLStatementParser.ConditionNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#statementInformationItemName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementInformationItemName(MySQLStatementParser.StatementInformationItemNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#conditionInformationItemName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionInformationItemName(MySQLStatementParser.ConditionInformationItemNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#handlerAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerAction(MySQLStatementParser.HandlerActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#conditionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionValue(MySQLStatementParser.ConditionValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#resignalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResignalStatement(MySQLStatementParser.ResignalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#signalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignalStatement(MySQLStatementParser.SignalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#signalInformationItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignalInformationItem(MySQLStatementParser.SignalInformationItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#prepare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrepare(MySQLStatementParser.PrepareContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#executeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuteStmt(MySQLStatementParser.ExecuteStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#executeVarList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuteVarList(MySQLStatementParser.ExecuteVarListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#deallocate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeallocate(MySQLStatementParser.DeallocateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#insert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert(MySQLStatementParser.InsertContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#insertSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertSpecification(MySQLStatementParser.InsertSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#insertValuesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertValuesClause(MySQLStatementParser.InsertValuesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#fields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFields(MySQLStatementParser.FieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#insertIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertIdentifier(MySQLStatementParser.InsertIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableWild}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableWild(MySQLStatementParser.TableWildContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#insertSelectClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertSelectClause(MySQLStatementParser.InsertSelectClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#onDuplicateKeyClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnDuplicateKeyClause(MySQLStatementParser.OnDuplicateKeyClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#valueReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueReference(MySQLStatementParser.ValueReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#derivedColumns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDerivedColumns(MySQLStatementParser.DerivedColumnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#replace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplace(MySQLStatementParser.ReplaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#replaceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceSpecification(MySQLStatementParser.ReplaceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#replaceValuesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceValuesClause(MySQLStatementParser.ReplaceValuesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#replaceSelectClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplaceSelectClause(MySQLStatementParser.ReplaceSelectClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate(MySQLStatementParser.UpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#updateSpecification_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSpecification_(MySQLStatementParser.UpdateSpecification_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MySQLStatementParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#setAssignmentsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetAssignmentsClause(MySQLStatementParser.SetAssignmentsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#assignmentValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentValues(MySQLStatementParser.AssignmentValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#assignmentValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentValue(MySQLStatementParser.AssignmentValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#blobValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlobValue(MySQLStatementParser.BlobValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#delete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete(MySQLStatementParser.DeleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#deleteSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteSpecification(MySQLStatementParser.DeleteSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#singleTableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTableClause(MySQLStatementParser.SingleTableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#multipleTablesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleTablesClause(MySQLStatementParser.MultipleTablesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect(MySQLStatementParser.SelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#selectWithInto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectWithInto(MySQLStatementParser.SelectWithIntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#queryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryExpression(MySQLStatementParser.QueryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#queryExpressionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryExpressionBody(MySQLStatementParser.QueryExpressionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#combineClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCombineClause(MySQLStatementParser.CombineClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#queryExpressionParens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryExpressionParens(MySQLStatementParser.QueryExpressionParensContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#queryPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryPrimary(MySQLStatementParser.QueryPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#querySpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuerySpecification(MySQLStatementParser.QuerySpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(MySQLStatementParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(MySQLStatementParser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#handlerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerStatement(MySQLStatementParser.HandlerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#handlerOpenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerOpenStatement(MySQLStatementParser.HandlerOpenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#handlerReadIndexStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerReadIndexStatement(MySQLStatementParser.HandlerReadIndexStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#handlerReadStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerReadStatement(MySQLStatementParser.HandlerReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#handlerCloseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerCloseStatement(MySQLStatementParser.HandlerCloseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(MySQLStatementParser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#loadStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadStatement(MySQLStatementParser.LoadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#loadDataStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadDataStatement(MySQLStatementParser.LoadDataStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#loadXmlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadXmlStatement(MySQLStatementParser.LoadXmlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableStatement(MySQLStatementParser.TableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableValueConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableValueConstructor(MySQLStatementParser.TableValueConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#rowConstructorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowConstructorList(MySQLStatementParser.RowConstructorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#withClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithClause(MySQLStatementParser.WithClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#cteClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCteClause(MySQLStatementParser.CteClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#selectSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectSpecification(MySQLStatementParser.SelectSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#duplicateSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuplicateSpecification(MySQLStatementParser.DuplicateSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#projections}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjections(MySQLStatementParser.ProjectionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#projection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjection(MySQLStatementParser.ProjectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#unqualifiedShorthand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnqualifiedShorthand(MySQLStatementParser.UnqualifiedShorthandContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#qualifiedShorthand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedShorthand(MySQLStatementParser.QualifiedShorthandContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(MySQLStatementParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableReferences}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableReferences(MySQLStatementParser.TableReferencesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#escapedTableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscapedTableReference(MySQLStatementParser.EscapedTableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableReference(MySQLStatementParser.TableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableFactor(MySQLStatementParser.TableFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#partitionNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionNames(MySQLStatementParser.PartitionNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#indexHintList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexHintList(MySQLStatementParser.IndexHintListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#indexHint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexHint(MySQLStatementParser.IndexHintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#joinedTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinedTable(MySQLStatementParser.JoinedTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#innerJoinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerJoinType(MySQLStatementParser.InnerJoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#outerJoinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOuterJoinType(MySQLStatementParser.OuterJoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#naturalJoinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalJoinType(MySQLStatementParser.NaturalJoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#joinSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinSpecification(MySQLStatementParser.JoinSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(MySQLStatementParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByClause(MySQLStatementParser.GroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#havingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingClause(MySQLStatementParser.HavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#limitClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitClause(MySQLStatementParser.LimitClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#limitRowCount}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitRowCount(MySQLStatementParser.LimitRowCountContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#limitOffset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitOffset(MySQLStatementParser.LimitOffsetContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#windowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowClause(MySQLStatementParser.WindowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#windowItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowItem(MySQLStatementParser.WindowItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#subquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubquery(MySQLStatementParser.SubqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#selectLinesInto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectLinesInto(MySQLStatementParser.SelectLinesIntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#selectFieldsInto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectFieldsInto(MySQLStatementParser.SelectFieldsIntoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#selectIntoExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectIntoExpression(MySQLStatementParser.SelectIntoExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#lockClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockClause(MySQLStatementParser.LockClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#lockClauseList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockClauseList(MySQLStatementParser.LockClauseListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#lockStrength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockStrength(MySQLStatementParser.LockStrengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#lockedRowAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockedRowAction(MySQLStatementParser.LockedRowActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableLockingList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableLockingList(MySQLStatementParser.TableLockingListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableIdentOptWild}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableIdentOptWild(MySQLStatementParser.TableIdentOptWildContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableAliasRefList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableAliasRefList(MySQLStatementParser.TableAliasRefListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#parameterMarker}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterMarker(MySQLStatementParser.ParameterMarkerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#customKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomKeyword(MySQLStatementParser.CustomKeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#literals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiterals(MySQLStatementParser.LiteralsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#string_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_(MySQLStatementParser.String_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#stringLiterals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiterals(MySQLStatementParser.StringLiteralsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#numberLiterals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiterals(MySQLStatementParser.NumberLiteralsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#temporalLiterals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalLiterals(MySQLStatementParser.TemporalLiteralsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#hexadecimalLiterals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexadecimalLiterals(MySQLStatementParser.HexadecimalLiteralsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#bitValueLiterals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitValueLiterals(MySQLStatementParser.BitValueLiteralsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#booleanLiterals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiterals(MySQLStatementParser.BooleanLiteralsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#nullValueLiterals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullValueLiterals(MySQLStatementParser.NullValueLiteralsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#collationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollationName(MySQLStatementParser.CollationNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MySQLStatementParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#identifierKeywordsUnambiguous}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierKeywordsUnambiguous(MySQLStatementParser.IdentifierKeywordsUnambiguousContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#identifierKeywordsAmbiguous1RolesAndLabels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierKeywordsAmbiguous1RolesAndLabels(MySQLStatementParser.IdentifierKeywordsAmbiguous1RolesAndLabelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#identifierKeywordsAmbiguous2Labels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierKeywordsAmbiguous2Labels(MySQLStatementParser.IdentifierKeywordsAmbiguous2LabelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#identifierKeywordsAmbiguous3Roles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierKeywordsAmbiguous3Roles(MySQLStatementParser.IdentifierKeywordsAmbiguous3RolesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#identifierKeywordsAmbiguous4SystemVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierKeywordsAmbiguous4SystemVariables(MySQLStatementParser.IdentifierKeywordsAmbiguous4SystemVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#textOrIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextOrIdentifier(MySQLStatementParser.TextOrIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#ipAddress}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIpAddress(MySQLStatementParser.IpAddressContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MySQLStatementParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#userVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserVariable(MySQLStatementParser.UserVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#systemVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemVariable(MySQLStatementParser.SystemVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#rvalueSystemVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRvalueSystemVariable(MySQLStatementParser.RvalueSystemVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#setSystemVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetSystemVariable(MySQLStatementParser.SetSystemVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#optionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionType(MySQLStatementParser.OptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#internalVariableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInternalVariableName(MySQLStatementParser.InternalVariableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#setExprOrDefault}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetExprOrDefault(MySQLStatementParser.SetExprOrDefaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#transactionCharacteristics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionCharacteristics(MySQLStatementParser.TransactionCharacteristicsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#isolationLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsolationLevel(MySQLStatementParser.IsolationLevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#isolationTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsolationTypes(MySQLStatementParser.IsolationTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#transactionAccessMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionAccessMode(MySQLStatementParser.TransactionAccessModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#schemaName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaName(MySQLStatementParser.SchemaNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#schemaNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaNames(MySQLStatementParser.SchemaNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#charsetName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharsetName(MySQLStatementParser.CharsetNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#schemaPairs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaPairs(MySQLStatementParser.SchemaPairsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#schemaPair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaPair(MySQLStatementParser.SchemaPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(MySQLStatementParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(MySQLStatementParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#indexName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexName(MySQLStatementParser.IndexNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#constraintName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintName(MySQLStatementParser.ConstraintNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#oldColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOldColumn(MySQLStatementParser.OldColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#newColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewColumn(MySQLStatementParser.NewColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#delimiterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelimiterName(MySQLStatementParser.DelimiterNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#userIdentifierOrText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserIdentifierOrText(MySQLStatementParser.UserIdentifierOrTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#username}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsername(MySQLStatementParser.UsernameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#eventName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventName(MySQLStatementParser.EventNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#serverName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServerName(MySQLStatementParser.ServerNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#wrapperName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrapperName(MySQLStatementParser.WrapperNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(MySQLStatementParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#procedureName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureName(MySQLStatementParser.ProcedureNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#viewName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewName(MySQLStatementParser.ViewNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#owner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOwner(MySQLStatementParser.OwnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlias(MySQLStatementParser.AliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(MySQLStatementParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableList(MySQLStatementParser.TableListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#viewNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewNames(MySQLStatementParser.ViewNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#columnNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnNames(MySQLStatementParser.ColumnNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#groupName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupName(MySQLStatementParser.GroupNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#routineName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineName(MySQLStatementParser.RoutineNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#shardLibraryName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShardLibraryName(MySQLStatementParser.ShardLibraryNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#componentName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentName(MySQLStatementParser.ComponentNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#pluginName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPluginName(MySQLStatementParser.PluginNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#hostname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHostname(MySQLStatementParser.HostnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#port}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPort(MySQLStatementParser.PortContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#cloneInstance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloneInstance(MySQLStatementParser.CloneInstanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#cloneDir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloneDir(MySQLStatementParser.CloneDirContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#channelName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelName(MySQLStatementParser.ChannelNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#logName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogName(MySQLStatementParser.LogNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#roleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleName(MySQLStatementParser.RoleNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#roleIdentifierOrText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleIdentifierOrText(MySQLStatementParser.RoleIdentifierOrTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#engineRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEngineRef(MySQLStatementParser.EngineRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#triggerName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerName(MySQLStatementParser.TriggerNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#triggerTime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerTime(MySQLStatementParser.TriggerTimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableOrTables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableOrTables(MySQLStatementParser.TableOrTablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#userOrRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserOrRole(MySQLStatementParser.UserOrRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#partitionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionName(MySQLStatementParser.PartitionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(MySQLStatementParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#allOrPartitionNameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllOrPartitionNameList(MySQLStatementParser.AllOrPartitionNameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#triggerEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerEvent(MySQLStatementParser.TriggerEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#triggerOrder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerOrder(MySQLStatementParser.TriggerOrderContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MySQLStatementParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#andOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOperator(MySQLStatementParser.AndOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#orOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrOperator(MySQLStatementParser.OrOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#notOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotOperator(MySQLStatementParser.NotOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#booleanPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanPrimary(MySQLStatementParser.BooleanPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(MySQLStatementParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(MySQLStatementParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(MySQLStatementParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#bitExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitExpr(MySQLStatementParser.BitExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#simpleExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpr(MySQLStatementParser.SimpleExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(MySQLStatementParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#onEmptyError}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnEmptyError(MySQLStatementParser.OnEmptyErrorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#columnRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnRef(MySQLStatementParser.ColumnRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#columnRefList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnRefList(MySQLStatementParser.ColumnRefListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(MySQLStatementParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#udfFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdfFunction(MySQLStatementParser.UdfFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#aggregationFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregationFunction(MySQLStatementParser.AggregationFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#jsonFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunction(MySQLStatementParser.JsonFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#jsonFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFunctionName(MySQLStatementParser.JsonFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#aggregationFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregationFunctionName(MySQLStatementParser.AggregationFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#distinct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistinct(MySQLStatementParser.DistinctContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#overClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverClause(MySQLStatementParser.OverClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#windowSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowSpecification(MySQLStatementParser.WindowSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#frameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrameClause(MySQLStatementParser.FrameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#frameStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrameStart(MySQLStatementParser.FrameStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#frameEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrameEnd(MySQLStatementParser.FrameEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#frameBetween}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrameBetween(MySQLStatementParser.FrameBetweenContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#specialFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialFunction(MySQLStatementParser.SpecialFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#currentUserFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrentUserFunction(MySQLStatementParser.CurrentUserFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#groupingFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingFunction(MySQLStatementParser.GroupingFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#timeStampDiffFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeStampDiffFunction(MySQLStatementParser.TimeStampDiffFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#groupConcatFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupConcatFunction(MySQLStatementParser.GroupConcatFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#windowFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunction(MySQLStatementParser.WindowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#windowingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowingClause(MySQLStatementParser.WindowingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#leadLagInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeadLagInfo(MySQLStatementParser.LeadLagInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#nullTreatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullTreatment(MySQLStatementParser.NullTreatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#checkType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckType(MySQLStatementParser.CheckTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#repairType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepairType(MySQLStatementParser.RepairTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#castFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastFunction(MySQLStatementParser.CastFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#convertFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConvertFunction(MySQLStatementParser.ConvertFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#castType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastType(MySQLStatementParser.CastTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#positionFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionFunction(MySQLStatementParser.PositionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#substringFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstringFunction(MySQLStatementParser.SubstringFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#extractFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractFunction(MySQLStatementParser.ExtractFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#charFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharFunction(MySQLStatementParser.CharFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#trimFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimFunction(MySQLStatementParser.TrimFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#valuesFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuesFunction(MySQLStatementParser.ValuesFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#weightStringFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightStringFunction(MySQLStatementParser.WeightStringFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#levelClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelClause(MySQLStatementParser.LevelClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#levelInWeightListElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevelInWeightListElement(MySQLStatementParser.LevelInWeightListElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#regularFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularFunction(MySQLStatementParser.RegularFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#shorthandRegularFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShorthandRegularFunction(MySQLStatementParser.ShorthandRegularFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#completeRegularFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompleteRegularFunction(MySQLStatementParser.CompleteRegularFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#regularFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularFunctionName(MySQLStatementParser.RegularFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#matchExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchExpression(MySQLStatementParser.MatchExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#matchSearchModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchSearchModifier(MySQLStatementParser.MatchSearchModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#caseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpression(MySQLStatementParser.CaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#datetimeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatetimeExpr(MySQLStatementParser.DatetimeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#binaryLogFileIndexNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryLogFileIndexNumber(MySQLStatementParser.BinaryLogFileIndexNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#caseWhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseWhen(MySQLStatementParser.CaseWhenContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#caseElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseElse(MySQLStatementParser.CaseElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#intervalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalExpression(MySQLStatementParser.IntervalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#intervalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalValue(MySQLStatementParser.IntervalValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#intervalUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalUnit(MySQLStatementParser.IntervalUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(MySQLStatementParser.OrderByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#orderByItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByItem(MySQLStatementParser.OrderByItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(MySQLStatementParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#stringList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringList(MySQLStatementParser.StringListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#textString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextString(MySQLStatementParser.TextStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#textStringHash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextStringHash(MySQLStatementParser.TextStringHashContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#fieldOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldOptions(MySQLStatementParser.FieldOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#precision}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecision(MySQLStatementParser.PrecisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#typeDatetimePrecision}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDatetimePrecision(MySQLStatementParser.TypeDatetimePrecisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#charsetWithOptBinary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharsetWithOptBinary(MySQLStatementParser.CharsetWithOptBinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#ascii}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAscii(MySQLStatementParser.AsciiContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#unicode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnicode(MySQLStatementParser.UnicodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#charset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharset(MySQLStatementParser.CharsetContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#defaultCollation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultCollation(MySQLStatementParser.DefaultCollationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#defaultEncryption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultEncryption(MySQLStatementParser.DefaultEncryptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#defaultCharset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultCharset(MySQLStatementParser.DefaultCharsetContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#now}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNow(MySQLStatementParser.NowContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#columnFormat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnFormat(MySQLStatementParser.ColumnFormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#storageMedia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageMedia(MySQLStatementParser.StorageMediaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#direction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirection(MySQLStatementParser.DirectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#keyOrIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyOrIndex(MySQLStatementParser.KeyOrIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#fieldLength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldLength(MySQLStatementParser.FieldLengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#characterSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterSet(MySQLStatementParser.CharacterSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#collateClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollateClause(MySQLStatementParser.CollateClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#fieldOrVarSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldOrVarSpec(MySQLStatementParser.FieldOrVarSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#ifNotExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNotExists(MySQLStatementParser.IfNotExistsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#ifExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExists(MySQLStatementParser.IfExistsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#connectionId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectionId(MySQLStatementParser.ConnectionIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#labelName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelName(MySQLStatementParser.LabelNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#cursorName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCursorName(MySQLStatementParser.CursorNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#conditionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionName(MySQLStatementParser.ConditionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#combineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCombineOption(MySQLStatementParser.CombineOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#noWriteToBinLog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoWriteToBinLog(MySQLStatementParser.NoWriteToBinLogContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#channelOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelOption(MySQLStatementParser.ChannelOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#use}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUse(MySQLStatementParser.UseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#help}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHelp(MySQLStatementParser.HelpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#explain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplain(MySQLStatementParser.ExplainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#fromSchema}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromSchema(MySQLStatementParser.FromSchemaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#fromTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromTable(MySQLStatementParser.FromTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showLike}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowLike(MySQLStatementParser.ShowLikeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showWhereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowWhereClause(MySQLStatementParser.ShowWhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowFilter(MySQLStatementParser.ShowFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showProfileType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowProfileType(MySQLStatementParser.ShowProfileTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#setVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetVariable(MySQLStatementParser.SetVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#optionValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionValueList(MySQLStatementParser.OptionValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#optionValueNoOptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionValueNoOptionType(MySQLStatementParser.OptionValueNoOptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#equal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(MySQLStatementParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#optionValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionValue(MySQLStatementParser.OptionValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showBinaryLogs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowBinaryLogs(MySQLStatementParser.ShowBinaryLogsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showBinlogEvents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowBinlogEvents(MySQLStatementParser.ShowBinlogEventsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showCharacterSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCharacterSet(MySQLStatementParser.ShowCharacterSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showCollation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCollation(MySQLStatementParser.ShowCollationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showColumns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowColumns(MySQLStatementParser.ShowColumnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showCreateDatabase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateDatabase(MySQLStatementParser.ShowCreateDatabaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showCreateEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateEvent(MySQLStatementParser.ShowCreateEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showCreateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateFunction(MySQLStatementParser.ShowCreateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showCreateProcedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateProcedure(MySQLStatementParser.ShowCreateProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showCreateTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateTable(MySQLStatementParser.ShowCreateTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showCreateTrigger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateTrigger(MySQLStatementParser.ShowCreateTriggerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showCreateUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateUser(MySQLStatementParser.ShowCreateUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showCreateView}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCreateView(MySQLStatementParser.ShowCreateViewContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showDatabases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowDatabases(MySQLStatementParser.ShowDatabasesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showEngine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowEngine(MySQLStatementParser.ShowEngineContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showEngines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowEngines(MySQLStatementParser.ShowEnginesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showErrors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowErrors(MySQLStatementParser.ShowErrorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showEvents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowEvents(MySQLStatementParser.ShowEventsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showFunctionCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowFunctionCode(MySQLStatementParser.ShowFunctionCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showFunctionStatus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowFunctionStatus(MySQLStatementParser.ShowFunctionStatusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showGrants}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowGrants(MySQLStatementParser.ShowGrantsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowIndex(MySQLStatementParser.ShowIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showMasterStatus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowMasterStatus(MySQLStatementParser.ShowMasterStatusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showOpenTables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowOpenTables(MySQLStatementParser.ShowOpenTablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showPlugins}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowPlugins(MySQLStatementParser.ShowPluginsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showPrivileges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowPrivileges(MySQLStatementParser.ShowPrivilegesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showProcedureCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowProcedureCode(MySQLStatementParser.ShowProcedureCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showProcedureStatus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowProcedureStatus(MySQLStatementParser.ShowProcedureStatusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showProcesslist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowProcesslist(MySQLStatementParser.ShowProcesslistContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showProfile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowProfile(MySQLStatementParser.ShowProfileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showProfiles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowProfiles(MySQLStatementParser.ShowProfilesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showRelaylogEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowRelaylogEvent(MySQLStatementParser.ShowRelaylogEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showReplicas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowReplicas(MySQLStatementParser.ShowReplicasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showSlaveHosts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowSlaveHosts(MySQLStatementParser.ShowSlaveHostsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showReplicaStatus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowReplicaStatus(MySQLStatementParser.ShowReplicaStatusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showSlaveStatus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowSlaveStatus(MySQLStatementParser.ShowSlaveStatusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showStatus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowStatus(MySQLStatementParser.ShowStatusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showTableStatus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowTableStatus(MySQLStatementParser.ShowTableStatusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showTables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowTables(MySQLStatementParser.ShowTablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showTriggers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowTriggers(MySQLStatementParser.ShowTriggersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowVariables(MySQLStatementParser.ShowVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showWarnings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowWarnings(MySQLStatementParser.ShowWarningsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#showCharset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowCharset(MySQLStatementParser.ShowCharsetContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#setCharacter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCharacter(MySQLStatementParser.SetCharacterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#clone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClone(MySQLStatementParser.CloneContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#cloneAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloneAction(MySQLStatementParser.CloneActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createLoadableFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateLoadableFunction(MySQLStatementParser.CreateLoadableFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#install}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstall(MySQLStatementParser.InstallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#uninstall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUninstall(MySQLStatementParser.UninstallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#installComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstallComponent(MySQLStatementParser.InstallComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#installPlugin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstallPlugin(MySQLStatementParser.InstallPluginContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#uninstallComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUninstallComponent(MySQLStatementParser.UninstallComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#uninstallPlugin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUninstallPlugin(MySQLStatementParser.UninstallPluginContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#analyzeTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnalyzeTable(MySQLStatementParser.AnalyzeTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#histogram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHistogram(MySQLStatementParser.HistogramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#checkTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckTable(MySQLStatementParser.CheckTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#checkTableOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckTableOption(MySQLStatementParser.CheckTableOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#checksumTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChecksumTable(MySQLStatementParser.ChecksumTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#optimizeTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptimizeTable(MySQLStatementParser.OptimizeTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#repairTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepairTable(MySQLStatementParser.RepairTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterResourceGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterResourceGroup(MySQLStatementParser.AlterResourceGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#vcpuSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVcpuSpec(MySQLStatementParser.VcpuSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createResourceGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateResourceGroup(MySQLStatementParser.CreateResourceGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropResourceGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropResourceGroup(MySQLStatementParser.DropResourceGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#setResourceGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetResourceGroup(MySQLStatementParser.SetResourceGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#binlog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinlog(MySQLStatementParser.BinlogContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#cacheIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCacheIndex(MySQLStatementParser.CacheIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#cacheTableIndexList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCacheTableIndexList(MySQLStatementParser.CacheTableIndexListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#partitionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionList(MySQLStatementParser.PartitionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#flush}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlush(MySQLStatementParser.FlushContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#flushOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlushOption(MySQLStatementParser.FlushOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tablesOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablesOption(MySQLStatementParser.TablesOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#kill}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKill(MySQLStatementParser.KillContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#loadIndexInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadIndexInfo(MySQLStatementParser.LoadIndexInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#loadTableIndexList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadTableIndexList(MySQLStatementParser.LoadTableIndexListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#resetStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetStatement(MySQLStatementParser.ResetStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#resetOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetOption(MySQLStatementParser.ResetOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#resetPersist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResetPersist(MySQLStatementParser.ResetPersistContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#restart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestart(MySQLStatementParser.RestartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#shutdown}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShutdown(MySQLStatementParser.ShutdownContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#explainType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplainType(MySQLStatementParser.ExplainTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#explainableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplainableStatement(MySQLStatementParser.ExplainableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#formatName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatName(MySQLStatementParser.FormatNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#delimiter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelimiter(MySQLStatementParser.DelimiterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#show}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow(MySQLStatementParser.ShowContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#setTransaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTransaction(MySQLStatementParser.SetTransactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#setAutoCommit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetAutoCommit(MySQLStatementParser.SetAutoCommitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#beginTransaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginTransaction(MySQLStatementParser.BeginTransactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#transactionCharacteristic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransactionCharacteristic(MySQLStatementParser.TransactionCharacteristicContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#commit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommit(MySQLStatementParser.CommitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#rollback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollback(MySQLStatementParser.RollbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#savepoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSavepoint(MySQLStatementParser.SavepointContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#begin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin(MySQLStatementParser.BeginContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#lock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLock(MySQLStatementParser.LockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#unlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnlock(MySQLStatementParser.UnlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#releaseSavepoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReleaseSavepoint(MySQLStatementParser.ReleaseSavepointContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#optionChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionChain(MySQLStatementParser.OptionChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#optionRelease}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionRelease(MySQLStatementParser.OptionReleaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tableLock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableLock(MySQLStatementParser.TableLockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#lockOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockOption(MySQLStatementParser.LockOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#xaBegin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaBegin(MySQLStatementParser.XaBeginContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#xaPrepare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaPrepare(MySQLStatementParser.XaPrepareContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#xaCommit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaCommit(MySQLStatementParser.XaCommitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#xaRollback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaRollback(MySQLStatementParser.XaRollbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#xaEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaEnd(MySQLStatementParser.XaEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#xaRecovery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXaRecovery(MySQLStatementParser.XaRecoveryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#xid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXid(MySQLStatementParser.XidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code grantRoleOrPrivilegeTo}
	 * labeled alternative in {@link MySQLStatementParser#grant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantRoleOrPrivilegeTo(MySQLStatementParser.GrantRoleOrPrivilegeToContext ctx);
	/**
	 * Visit a parse tree produced by the {@code grantRoleOrPrivilegeOnTo}
	 * labeled alternative in {@link MySQLStatementParser#grant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantRoleOrPrivilegeOnTo(MySQLStatementParser.GrantRoleOrPrivilegeOnToContext ctx);
	/**
	 * Visit a parse tree produced by the {@code grantProxy}
	 * labeled alternative in {@link MySQLStatementParser#grant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantProxy(MySQLStatementParser.GrantProxyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code revokeFrom}
	 * labeled alternative in {@link MySQLStatementParser#revoke}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRevokeFrom(MySQLStatementParser.RevokeFromContext ctx);
	/**
	 * Visit a parse tree produced by the {@code revokeOnFrom}
	 * labeled alternative in {@link MySQLStatementParser#revoke}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRevokeOnFrom(MySQLStatementParser.RevokeOnFromContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#userList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserList(MySQLStatementParser.UserListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#roleOrPrivileges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleOrPrivileges(MySQLStatementParser.RoleOrPrivilegesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code roleOrDynamicPrivilege}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleOrDynamicPrivilege(MySQLStatementParser.RoleOrDynamicPrivilegeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code roleAtHost}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleAtHost(MySQLStatementParser.RoleAtHostContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeSelect}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeSelect(MySQLStatementParser.StaticPrivilegeSelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeInsert}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeInsert(MySQLStatementParser.StaticPrivilegeInsertContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeUpdate}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeUpdate(MySQLStatementParser.StaticPrivilegeUpdateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeReferences}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeReferences(MySQLStatementParser.StaticPrivilegeReferencesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeDelete}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeDelete(MySQLStatementParser.StaticPrivilegeDeleteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeUsage}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeUsage(MySQLStatementParser.StaticPrivilegeUsageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeIndex}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeIndex(MySQLStatementParser.StaticPrivilegeIndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeAlter}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeAlter(MySQLStatementParser.StaticPrivilegeAlterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeCreate}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeCreate(MySQLStatementParser.StaticPrivilegeCreateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeDrop}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeDrop(MySQLStatementParser.StaticPrivilegeDropContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeExecute}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeExecute(MySQLStatementParser.StaticPrivilegeExecuteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeReload}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeReload(MySQLStatementParser.StaticPrivilegeReloadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeShutdown}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeShutdown(MySQLStatementParser.StaticPrivilegeShutdownContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeProcess}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeProcess(MySQLStatementParser.StaticPrivilegeProcessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeFile}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeFile(MySQLStatementParser.StaticPrivilegeFileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeGrant}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeGrant(MySQLStatementParser.StaticPrivilegeGrantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeShowDatabases}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeShowDatabases(MySQLStatementParser.StaticPrivilegeShowDatabasesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeSuper}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeSuper(MySQLStatementParser.StaticPrivilegeSuperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeCreateTemporaryTables}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeCreateTemporaryTables(MySQLStatementParser.StaticPrivilegeCreateTemporaryTablesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeLockTables}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeLockTables(MySQLStatementParser.StaticPrivilegeLockTablesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeReplicationSlave}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeReplicationSlave(MySQLStatementParser.StaticPrivilegeReplicationSlaveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeReplicationClient}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeReplicationClient(MySQLStatementParser.StaticPrivilegeReplicationClientContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeCreateView}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeCreateView(MySQLStatementParser.StaticPrivilegeCreateViewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeShowView}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeShowView(MySQLStatementParser.StaticPrivilegeShowViewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeCreateRoutine}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeCreateRoutine(MySQLStatementParser.StaticPrivilegeCreateRoutineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeAlterRoutine}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeAlterRoutine(MySQLStatementParser.StaticPrivilegeAlterRoutineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeCreateUser}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeCreateUser(MySQLStatementParser.StaticPrivilegeCreateUserContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeEvent}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeEvent(MySQLStatementParser.StaticPrivilegeEventContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeTrigger}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeTrigger(MySQLStatementParser.StaticPrivilegeTriggerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeCreateTablespace}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeCreateTablespace(MySQLStatementParser.StaticPrivilegeCreateTablespaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeCreateRole}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeCreateRole(MySQLStatementParser.StaticPrivilegeCreateRoleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticPrivilegeDropRole}
	 * labeled alternative in {@link MySQLStatementParser#roleOrPrivilege}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticPrivilegeDropRole(MySQLStatementParser.StaticPrivilegeDropRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#aclType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAclType(MySQLStatementParser.AclTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code grantLevelGlobal}
	 * labeled alternative in {@link MySQLStatementParser#grantIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantLevelGlobal(MySQLStatementParser.GrantLevelGlobalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code grantLevelSchemaGlobal}
	 * labeled alternative in {@link MySQLStatementParser#grantIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantLevelSchemaGlobal(MySQLStatementParser.GrantLevelSchemaGlobalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code grantLevelTable}
	 * labeled alternative in {@link MySQLStatementParser#grantIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantLevelTable(MySQLStatementParser.GrantLevelTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUser(MySQLStatementParser.CreateUserContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createUserEntryNoOption}
	 * labeled alternative in {@link MySQLStatementParser#createUserEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUserEntryNoOption(MySQLStatementParser.CreateUserEntryNoOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createUserEntryIdentifiedBy}
	 * labeled alternative in {@link MySQLStatementParser#createUserEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUserEntryIdentifiedBy(MySQLStatementParser.CreateUserEntryIdentifiedByContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createUserEntryIdentifiedWith}
	 * labeled alternative in {@link MySQLStatementParser#createUserEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUserEntryIdentifiedWith(MySQLStatementParser.CreateUserEntryIdentifiedWithContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createUserList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateUserList(MySQLStatementParser.CreateUserListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#defaultRoleClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultRoleClause(MySQLStatementParser.DefaultRoleClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#requireClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequireClause(MySQLStatementParser.RequireClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#connectOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectOptions(MySQLStatementParser.ConnectOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#accountLockPasswordExpireOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccountLockPasswordExpireOptions(MySQLStatementParser.AccountLockPasswordExpireOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#accountLockPasswordExpireOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccountLockPasswordExpireOption(MySQLStatementParser.AccountLockPasswordExpireOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUser(MySQLStatementParser.AlterUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterUserEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUserEntry(MySQLStatementParser.AlterUserEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#alterUserList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterUserList(MySQLStatementParser.AlterUserListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropUser(MySQLStatementParser.DropUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#createRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateRole(MySQLStatementParser.CreateRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#dropRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropRole(MySQLStatementParser.DropRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#renameUser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameUser(MySQLStatementParser.RenameUserContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#setDefaultRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDefaultRole(MySQLStatementParser.SetDefaultRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#setRole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetRole(MySQLStatementParser.SetRoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#setPassword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetPassword(MySQLStatementParser.SetPasswordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#authOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthOption(MySQLStatementParser.AuthOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#withGrantOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithGrantOption(MySQLStatementParser.WithGrantOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#userOrRoles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserOrRoles(MySQLStatementParser.UserOrRolesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#roles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoles(MySQLStatementParser.RolesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#grantAs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrantAs(MySQLStatementParser.GrantAsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#withRoles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithRoles(MySQLStatementParser.WithRolesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#userAuthOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserAuthOption(MySQLStatementParser.UserAuthOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#identifiedBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifiedBy(MySQLStatementParser.IdentifiedByContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#identifiedWith}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifiedWith(MySQLStatementParser.IdentifiedWithContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#connectOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectOption(MySQLStatementParser.ConnectOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tlsOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTlsOption(MySQLStatementParser.TlsOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#userFuncAuthOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserFuncAuthOption(MySQLStatementParser.UserFuncAuthOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#change}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange(MySQLStatementParser.ChangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#changeMasterTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeMasterTo(MySQLStatementParser.ChangeMasterToContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#changeReplicationFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeReplicationFilter(MySQLStatementParser.ChangeReplicationFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#changeReplicationSourceTo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeReplicationSourceTo(MySQLStatementParser.ChangeReplicationSourceToContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#startSlave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartSlave(MySQLStatementParser.StartSlaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#stopSlave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopSlave(MySQLStatementParser.StopSlaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#groupReplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupReplication(MySQLStatementParser.GroupReplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#startGroupReplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartGroupReplication(MySQLStatementParser.StartGroupReplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#stopGroupReplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopGroupReplication(MySQLStatementParser.StopGroupReplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#purgeBinaryLog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPurgeBinaryLog(MySQLStatementParser.PurgeBinaryLogContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#threadTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThreadTypes(MySQLStatementParser.ThreadTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#threadType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThreadType(MySQLStatementParser.ThreadTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#utilOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUtilOption(MySQLStatementParser.UtilOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#connectionOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectionOptions(MySQLStatementParser.ConnectionOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#masterDefs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterDefs(MySQLStatementParser.MasterDefsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#masterDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasterDef(MySQLStatementParser.MasterDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#ignoreServerIds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreServerIds(MySQLStatementParser.IgnoreServerIdsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#ignoreServerId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreServerId(MySQLStatementParser.IgnoreServerIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#filterDefs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterDefs(MySQLStatementParser.FilterDefsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#filterDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterDef(MySQLStatementParser.FilterDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#wildTables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildTables(MySQLStatementParser.WildTablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#wildTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildTable(MySQLStatementParser.WildTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#changeReplicationSourceOptionDefs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeReplicationSourceOptionDefs(MySQLStatementParser.ChangeReplicationSourceOptionDefsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#changeReplicationSourceOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeReplicationSourceOption(MySQLStatementParser.ChangeReplicationSourceOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#tablePrimaryKeyCheckDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablePrimaryKeyCheckDef(MySQLStatementParser.TablePrimaryKeyCheckDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLStatementParser#assignGtidsToAnonymousTransactionsDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignGtidsToAnonymousTransactionsDef(MySQLStatementParser.AssignGtidsToAnonymousTransactionsDefContext ctx);
}