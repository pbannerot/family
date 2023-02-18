/**
 */
package com.esolution.family.model.family;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.esolution.family.model.family.Person#getName <em>Name</em>}</li>
 *   <li>{@link com.esolution.family.model.family.Person#getAge <em>Age</em>}</li>
 *   <li>{@link com.esolution.family.model.family.Person#getMother <em>Mother</em>}</li>
 *   <li>{@link com.esolution.family.model.family.Person#getFather <em>Father</em>}</li>
 *   <li>{@link com.esolution.family.model.family.Person#getChildren <em>Children</em>}</li>
 *   <li>{@link com.esolution.family.model.family.Person#getParents <em>Parents</em>}</li>
 * </ul>
 *
 * @see com.esolution.family.model.family.FamilyPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.esolution.family.model.family.FamilyPackage#getPerson_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.esolution.family.model.family.Person#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see com.esolution.family.model.family.FamilyPackage#getPerson_Age()
	 * @model default="0"
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link com.esolution.family.model.family.Person#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

	/**
	 * Returns the value of the '<em><b>Mother</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mother</em>' reference.
	 * @see #setMother(Woman)
	 * @see com.esolution.family.model.family.FamilyPackage#getPerson_Mother()
	 * @model derived="true"
	 * @generated
	 */
	Woman getMother();

	/**
	 * Sets the value of the '{@link com.esolution.family.model.family.Person#getMother <em>Mother</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mother</em>' reference.
	 * @see #getMother()
	 * @generated
	 */
	void setMother(Woman value);

	/**
	 * Returns the value of the '<em><b>Father</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Father</em>' reference.
	 * @see #setFather(Man)
	 * @see com.esolution.family.model.family.FamilyPackage#getPerson_Father()
	 * @model derived="true"
	 * @generated
	 */
	Man getFather();

	/**
	 * Sets the value of the '{@link com.esolution.family.model.family.Person#getFather <em>Father</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Father</em>' reference.
	 * @see #getFather()
	 * @generated
	 */
	void setFather(Man value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link com.esolution.family.model.family.Person}.
	 * It is bidirectional and its opposite is '{@link com.esolution.family.model.family.Person#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see com.esolution.family.model.family.FamilyPackage#getPerson_Children()
	 * @see com.esolution.family.model.family.Person#getParents
	 * @model opposite="parents"
	 * @generated
	 */
	EList<Person> getChildren();

	/**
	 * Returns the value of the '<em><b>Parents</b></em>' reference list.
	 * The list contents are of type {@link com.esolution.family.model.family.Person}.
	 * It is bidirectional and its opposite is '{@link com.esolution.family.model.family.Person#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parents</em>' reference list.
	 * @see com.esolution.family.model.family.FamilyPackage#getPerson_Parents()
	 * @see com.esolution.family.model.family.Person#getChildren
	 * @model opposite="children" upper="2"
	 * @generated
	 */
	EList<Person> getParents();

} // Person
