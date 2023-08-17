//
//  Deuda+CoreDataProperties.swift
//  ControlGastos
//
//  Created by Joel on 17/08/23.
//
//

import Foundation
import CoreData


extension Deuda {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<Deuda> {
        return NSFetchRequest<Deuda>(entityName: "Deuda")
    }

    @NSManaged public var descrip: String?
    @NSManaged public var monto: Double
    @NSManaged public var metodo: String?

}

extension Deuda : Identifiable {

}
