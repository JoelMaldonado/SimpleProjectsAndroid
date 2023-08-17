//
//  Prueba+CoreDataProperties.swift
//  ControlGastos
//
//  Created by Joel on 17/08/23.
//
//

import Foundation
import CoreData


extension Prueba {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<Prueba> {
        return NSFetchRequest<Prueba>(entityName: "Prueba")
    }

    @NSManaged public var name: String?

}

extension Prueba : Identifiable {

}
