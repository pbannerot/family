/**
 */
package com.esolution.family.model.family.impl;

import com.esolution.family.model.family.FamilyPackage;
import com.esolution.family.model.family.Man;
import com.esolution.family.model.family.Person;
import com.esolution.family.model.family.Woman;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.esolution.family.model.family.impl.PersonImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.esolution.family.model.family.impl.PersonImpl#getAge <em>Age</em>}</li>
 *   <li>{@link com.esolution.family.model.family.impl.PersonImpl#getMother <em>Mother</em>}</li>
 *   <li>{@link com.esolution.family.model.family.impl.PersonImpl#getFather <em>Father</em>}</li>
 *   <li>{@link com.esolution.family.model.family.impl.PersonImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link com.esolution.family.model.family.impl.PersonImpl#getParents <em>Parents</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonImpl extends MinimalEObjectImpl.Container implements Person {
	final private static Logger logger = Logger.getLogger(PersonImpl.class);
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected static final int AGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected int age = AGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMother() <em>Mother</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMother()
	 * @generated
	 * @ordered
	 */
	protected Woman mother;

	/**
	 * The cached value of the '{@link #getFather() <em>Father</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFather()
	 * @generated
	 * @ordered
	 */
	protected Man father;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> children;

	/**
	 * The cached value of the '{@link #getParents() <em>Parents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParents()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> parents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	protected PersonImpl() {
		super();

		EContentAdapter adapter = new EContentAdapter() {
			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);

				EStructuralFeature eStructuralFeature = (EStructuralFeature) notification.getFeature();

				switch (notification.getEventType()) {
				case Notification.SET:
					if ((notification.getNotifier() instanceof Person)
							&& (eStructuralFeature.getFeatureID() == FamilyPackage.FAMILY__MEMBERS)) {
						logger.info("Notification SET -> FamilyPackage.FAMILY__MEMBERS");
					} else {
						logger.info("Notification SET -> " + eStructuralFeature.getName());
					}
					if ((notification.getNotifier() instanceof Person)
							&& (eStructuralFeature.getFeatureID() == FamilyPackage.PERSON__PARENTS)) {
						logger.debug(getName() + " parent de " + ((Person) notification.getNewValue()).getName());
					}
					if ((notification.getNotifier() instanceof Person)
							&& (eStructuralFeature.getFeatureID() == FamilyPackage.PERSON__CHILDREN)) {
						logger.debug(getName() + " enfant de " + ((Person) notification.getNewValue()).getName());
					}
					break;
				case Notification.ADD:
					logger.info("Notification ADD -> " + eStructuralFeature.getName());
					Person person = (Person) notification.getNewValue();
					if ((notification.getNotifier() instanceof Person)
							&& (eStructuralFeature.getFeatureID() == FamilyPackage.PERSON__PARENTS)) {
						logger.debug(person.getName() + " parent de " + getName());

						if (person instanceof Woman) {
							setMother((Woman) person);
						}
						if (person instanceof Man) {
							setFather((Man) person);
						}
					}
					if ((notification.getNotifier() instanceof Person)
							&& (eStructuralFeature.getFeatureID() == FamilyPackage.PERSON__CHILDREN)) {
						logger.debug(person.getName() + " enfant de " + getName());

					}
					break;
				case Notification.ADD_MANY:
					@SuppressWarnings("unchecked") ArrayList<Person> persons = (ArrayList<Person>) notification.getNewValue();
					for (Person p : persons) {
						eNotify(new ENotificationImpl((InternalEObject) notification.getNotifier(), Notification.ADD, FamilyPackage.PERSON__PARENTS, null, p));
					}
					break;
				case Notification.REMOVE:
					if (notification.getOldValue() instanceof Woman) {
						setMother(null);
					}
					if (notification.getOldValue() instanceof Man) {
						setFather(null);
					}
					break;
				case Notification.REMOVE_MANY:
					logger.error("TODO: implements REMOVE_MANY");
					break;
				}
			}
		};
		eAdapters().add(adapter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FamilyPackage.Literals.PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamilyPackage.PERSON__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getAge() {
		return age;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAge(int newAge) {
		int oldAge = age;
		age = newAge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamilyPackage.PERSON__AGE, oldAge, age));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Woman getMother() {
		if (mother != null && mother.eIsProxy()) {
			InternalEObject oldMother = (InternalEObject) mother;
			mother = (Woman) eResolveProxy(oldMother);
			if (mother != oldMother) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FamilyPackage.PERSON__MOTHER, oldMother,
							mother));
			}
		}
		return mother;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Woman basicGetMother() {
		return mother;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMother(Woman newMother) {
		Woman oldMother = mother;
		mother = newMother;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamilyPackage.PERSON__MOTHER, oldMother, mother));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Man getFather() {
		if (father != null && father.eIsProxy()) {
			InternalEObject oldFather = (InternalEObject) father;
			father = (Man) eResolveProxy(oldFather);
			if (father != oldFather) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FamilyPackage.PERSON__FATHER, oldFather,
							father));
			}
		}
		return father;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Man basicGetFather() {
		return father;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFather(Man newFather) {
		Man oldFather = father;
		father = newFather;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FamilyPackage.PERSON__FATHER, oldFather, father));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Person> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList.ManyInverse<Person>(Person.class, this,
					FamilyPackage.PERSON__CHILDREN, FamilyPackage.PERSON__PARENTS);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Person> getParents() {
		if (parents == null) {
			parents = new EObjectWithInverseResolvingEList.ManyInverse<Person>(Person.class, this,
					FamilyPackage.PERSON__PARENTS, FamilyPackage.PERSON__CHILDREN);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FamilyPackage.PERSON__CHILDREN:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildren()).basicAdd(otherEnd, msgs);
		case FamilyPackage.PERSON__PARENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getParents()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case FamilyPackage.PERSON__CHILDREN:
			return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
		case FamilyPackage.PERSON__PARENTS:
			return ((InternalEList<?>) getParents()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case FamilyPackage.PERSON__NAME:
			return getName();
		case FamilyPackage.PERSON__AGE:
			return getAge();
		case FamilyPackage.PERSON__MOTHER:
			if (resolve)
				return getMother();
			return basicGetMother();
		case FamilyPackage.PERSON__FATHER:
			if (resolve)
				return getFather();
			return basicGetFather();
		case FamilyPackage.PERSON__CHILDREN:
			return getChildren();
		case FamilyPackage.PERSON__PARENTS:
			return getParents();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case FamilyPackage.PERSON__NAME:
			setName((String) newValue);
			return;
		case FamilyPackage.PERSON__AGE:
			setAge((Integer) newValue);
			return;
		case FamilyPackage.PERSON__MOTHER:
			setMother((Woman) newValue);
			return;
		case FamilyPackage.PERSON__FATHER:
			setFather((Man) newValue);
			return;
		case FamilyPackage.PERSON__CHILDREN:
			getChildren().clear();
			getChildren().addAll((Collection<? extends Person>) newValue);
			return;
		case FamilyPackage.PERSON__PARENTS:
			getParents().clear();
			getParents().addAll((Collection<? extends Person>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case FamilyPackage.PERSON__NAME:
			setName(NAME_EDEFAULT);
			return;
		case FamilyPackage.PERSON__AGE:
			setAge(AGE_EDEFAULT);
			return;
		case FamilyPackage.PERSON__MOTHER:
			setMother((Woman) null);
			return;
		case FamilyPackage.PERSON__FATHER:
			setFather((Man) null);
			return;
		case FamilyPackage.PERSON__CHILDREN:
			getChildren().clear();
			return;
		case FamilyPackage.PERSON__PARENTS:
			getParents().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case FamilyPackage.PERSON__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case FamilyPackage.PERSON__AGE:
			return age != AGE_EDEFAULT;
		case FamilyPackage.PERSON__MOTHER:
			return mother != null;
		case FamilyPackage.PERSON__FATHER:
			return father != null;
		case FamilyPackage.PERSON__CHILDREN:
			return children != null && !children.isEmpty();
		case FamilyPackage.PERSON__PARENTS:
			return parents != null && !parents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", age: ");
		result.append(age);
		result.append(')');
		return result.toString();
	}

} //PersonImpl
