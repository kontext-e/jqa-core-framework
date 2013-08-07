package com.buschmais.jqassistant.core.model.api.descriptor;

import java.util.HashSet;
import java.util.Set;

/**
 * Describes a method of a Java class.
 */
public class MethodDescriptor extends AbstractDescriptor implements DependentDescriptor, AnnotatedDescriptor,
		AccessModifierDescriptor {

    /**
     * The declared throwables.
     */
    private Set<TypeDescriptor> declaredThrowables = new HashSet<TypeDescriptor>();

    /**
     * The classes the method depends on.
     */
    private Set<TypeDescriptor> dependencies = new HashSet<TypeDescriptor>();

    /**
     * The classes this class is annotated by.
     */
    private Set<TypeDescriptor> annotations = new HashSet<TypeDescriptor>();

	private Boolean nativeMethod;

	/**
	 * <code>true</code> if this method is abstract.
	 */
	private Boolean abstractMethod;

	/**
	 * Visibility of this method.
	 */
	private VisibilityModifier visbility;

	/**
	 * <code>true</code> if this method is static, otherwise <code>false</code>.
	 */
	private Boolean staticMethod;

	/**
	 * <code>true</code> if this method is final, otherwise <code>false</code>.
	 */
	private Boolean finalMethod;

	/**
	 * Return the declared throwables.
	 *
	 * @return The declared throwables.
	 */
    public Set<TypeDescriptor> getDeclaredThrowables() {
        return declaredThrowables;
    }

    /**
     * Set the declared throwables.
     *
     * @param declaredThrowables The declared throwables.
     */
    public void setDeclaredThrowables(Set<TypeDescriptor> declaredThrowables) {
        this.declaredThrowables = declaredThrowables;
    }

    @Override
    public Set<TypeDescriptor> getDependencies() {
        return dependencies;
    }

    @Override
    public void setDependencies(Set<TypeDescriptor> dependencies) {
        this.dependencies = dependencies;
    }

    @Override
    public Set<TypeDescriptor> getAnnotatedBy() {
        return annotations;
    }

    @Override
    public void setAnnotatedBy(Set<TypeDescriptor> annotations) {
        this.annotations = annotations;
    }

	/**
	 * @return the abstractClass
	 */
	public Boolean isAbstract() {
		return abstractMethod;
	}

	/**
	 * @param abstractClass
	 *            the abstractClass to set
	 */
	public void setAbstract(Boolean abstractClass) {
		this.abstractMethod = abstractClass;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VisibilityModifier getVisibility() {
		return visbility;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setVisibility(VisibilityModifier visibilityModifier) {
		visbility = visibilityModifier;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean isStatic() {
		return staticMethod;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStatic(Boolean s) {
		staticMethod = s;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean isFinal() {
		return finalMethod;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFinal(Boolean f) {
		finalMethod = f;
	}

	/**
	 * @return the nativeMethod
	 */
	public Boolean isNative() {
		return nativeMethod;
	}

	/**
	 * @param nativeMethod
	 *            the nativeMethod to set
	 */
	public void setNative(Boolean nativeMethod) {
		this.nativeMethod = nativeMethod;
	}

}
