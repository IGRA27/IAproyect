import sys
import pickle
import pandas as pd
import numpy as np
from keras.models import load_model
import os
#ISAAC REYES
if __name__ == '__main__':
    values = [[el for el in list(map(str, sys.argv[1:]))]]
    
    model = load_model(os.getcwd() + "\\src\\redesneuronales\\model_clasificacion.h5")
with open("scaler_clasificacion.pkl", "rb") as file:
scaler=pickle.load (file)
features_names = ['Lands (without MDFCS)',
'Average mana value (counting land/spell MDFCs as spells)',
'Nonmythic land/spell MDFCs', 'Mythic land/spell MDFCS', 'Cheap card draw',
'Cheap mana prod','Sum of cheap card draw and cheap mana prod',
'Format','Companion present (1 or 0)', 'Wins', 'Losses','Month', 'Year']
df = pd.DataFrame(values, columns=features_names)

    X_scaled = scaler.transform(df);

    predict = model.predict(X_scaled)
    predict = np.argmax(predict, axis=1)
    print(predict[0])