def soma(x):
    if x == []:
        return 0
    else:
        return x[0] + soma(x[1:])

print(soma([1, 2, 3, 4]))
print(soma([]))
print(soma([1]))


def conta(x):
    if x == []:
        return 0
    return 1 + conta(x[1:])

print(conta([1, 5, 2, 43, 123, 45]))
print(conta([1]))
print(conta([]))

def maior(x):
    if len(x) == 1:
        return x[0]
    return x[0] if x[0] > maior(x[1:]) else maior(x[1:])

print(maior([3, 7, 5, 8]))
