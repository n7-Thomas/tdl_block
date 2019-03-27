/**
 * 
 */
package fr.n7.stl.block.ast.expression;

import fr.n7.stl.block.ast.SemanticsUndefinedException;
import fr.n7.stl.block.ast.scope.Declaration;
import fr.n7.stl.block.ast.scope.HierarchicalScope;
import fr.n7.stl.block.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Abstract Syntax Tree node for an expression extracting the first component in a couple.
 * @author Marc Pantel
 *
 */
public class TypeCast implements Expression {
	
	protected String type;

	/**
	 * AST node for the expression whose value must whose first element is extracted by the expression.
	 */
	protected Expression target;

	/**
	 * Builds an Abstract Syntax Tree node for an expression extracting the first component of a couple.
	 * @param _target : AST node for the expression whose value must whose first element is extracted by the expression.
	 */
	public TypeCast(Expression _target, String _type) {
		this.target = _target;
		this.type = _type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "((" + this.type + ") " + this.target + ")";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.expression.Expression#resolve(fr.n7.stl.block.ast.scope.HierarchicalScope)
	 */
	@Override
	public boolean resolve(HierarchicalScope<Declaration> _scope) {
		boolean _ok = this.target.resolve(_scope);
		return _ok;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType undefined in Type Cast.");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("Semantics getCode undefined in Type Cast.");
	}

}
