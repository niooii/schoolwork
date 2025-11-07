import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

df = pd.read_csv("../benchmark_results.csv")

df_clean = df[~df['Time_ms'].isin(['FAILED', 'SKIP'])].copy()
df_clean['Time_ms'] = pd.to_numeric(df_clean['Time_ms'])

data_types = df_clean['DataType'].unique()

fig, axes = plt.subplots(1, 3, figsize=(20, 6))
fig.suptitle('Sorting Algorithm Performance Comparison', fontsize=16)

for idx, data_type in enumerate(data_types):
    ax = axes[idx]
    data = df_clean[df_clean['DataType'] == data_type]

    for algo in data['Algorithm'].unique():
        algo_data = data[data['Algorithm'] == algo]
        ax.plot(algo_data['Size'], algo_data['Time_ms'], marker='o', label=algo, alpha=0.7)

    ax.set_xlabel('Array Size')
    ax.set_ylabel('Time (ms)')
    ax.set_title(f'{data_type.capitalize()} Data')
    ax.set_xscale('log')
    ax.set_yscale('log')
    ax.grid(True, alpha=0.3)
    ax.legend(bbox_to_anchor=(1.05, 1), loc='upper left', fontsize=8)

plt.tight_layout()
plt.savefig('benchmark_comparison.png', dpi=300, bbox_inches='tight')
print("Plot saved as benchmark_comparison.png")

top_performers = {}
for data_type in data_types:
    data = df_clean[df_clean['DataType'] == data_type]
    max_size_data = data[data['Size'] == data['Size'].max()]
    top3 = max_size_data.nsmallest(3, 'Time_ms')[['Algorithm', 'Time_ms']]
    top_performers[data_type] = top3

print("\nTop 3 Fastest Algorithms at Maximum Size:")
for dt, top3 in top_performers.items():
    print(f"\n{dt.capitalize()}:")
    for _, row in top3.iterrows():
        print(f"  {row['Algorithm']}: {row['Time_ms']:.2f} ms")
