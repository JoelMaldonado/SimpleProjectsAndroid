//
//  MenuScreen.swift
//  ControlGastos
//
//  Created by Joel on 17/08/23.
//

import SwiftUI

struct MenuScreen: View {
    
    @State private var selectedTab = 0
    var body: some View {
        TabView(selection: $selectedTab) {
            HomeScreen()
                .tabItem {
                    Image(systemName: "house")
                    Text("Inicio")
                }
                .tag(0)
            
            PerfilSreen()
                .tabItem {
                    Image(systemName: "heart")
                    Text("Favoritos")
                }
                .tag(1)
            
            Text("Página 3")
                .tabItem {
                    Image(systemName: "person")
                    Text("Perfil")
                }
                .tag(2)
        }
    }
}
