//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                          R e l a t i o n                                       //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//
//  Copyright © Audiveris 2017. All rights reserved.
//
//  This program is free software: you can redistribute it and/or modify it under the terms of the
//  GNU Affero General Public License as published by the Free Software Foundation, either version
//  3 of the License, or (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
//  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
//  See the GNU Affero General Public License for more details.
//
//  You should have received a copy of the GNU Affero General Public License along with this
//  program.  If not, see <http://www.gnu.org/licenses/>.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package org.audiveris.omr.sig.relation;

import org.audiveris.omr.sig.SIGraph;
import org.audiveris.omr.sig.inter.Inter;

import org.jgrapht.event.GraphEdgeChangeEvent;

/**
 * Interface {@code Relation} describes a relation between two Interpretation instances.
 *
 * @author Hervé Bitteur
 */
public interface Relation
{
    //~ Methods ------------------------------------------------------------------------------------

    /**
     * Notifies that this relation has been added to the sig.
     *
     * @param e the relation event.
     */
    void added (GraphEdgeChangeEvent<Inter, Relation> e);

    /**
     * Clone a relation.
     *
     * @return the cloned relation
     */
    Relation duplicate ();

    /**
     * Details for tip.
     *
     * @return relation details
     */
    String getDetails ();

    /**
     * Short name.
     *
     * @return the relation short name
     */
    String getName ();

    /**
     * Report whether this relation has been set manually.
     *
     * @return true if manual
     */
    boolean isManual ();

    /**
     * Tell if, seen from a given target, there can be at most one source.
     *
     * @return true if source number is limited to 1, false by default
     */
    boolean isSingleSource ();

    /**
     * Tell if, seen from a given source, there can be at most one target.
     *
     * @return true if target number is limited to 1, false by default
     */
    boolean isSingleTarget ();

    /**
     * Notifies that this relation has been removed from the sig.
     *
     * @param e the relation event.
     */
    void removed (GraphEdgeChangeEvent<Inter, Relation> e);

    /**
     * Relation description when seen from one of its involved inters
     *
     * @param inter the interpretation point of view
     * @return the inter-based description
     */
    String seenFrom (Inter inter);

    /**
     * Set this relation as a manual one.
     *
     * @param manual new value
     */
    void setManual (boolean manual);

    /**
     * Report a long description of the relation
     *
     * @param sig the containing sig
     * @return long description
     */
    String toLongString (SIGraph sig);
}
